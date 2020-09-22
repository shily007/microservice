package com.dy.api.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionHolder;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;

public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {

	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	protected M baseMapper;

	/**
	 * @param result
	 * @return boolean
	 */
	protected boolean retBool(Integer result) {
		return SqlHelper.retBool(result);
	}

	@SuppressWarnings("unchecked")
	protected Class<T> currentModelClass() {
		return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
	}

	/**
	 * SqlSession
	 */
	protected SqlSession sqlSessionBatch() {
		return SqlHelper.sqlSessionBatch(currentModelClass());
	}

	/**
	 * sqlSession
	 *
	 * @param sqlSession session
	 */
	protected void closeSqlSession(SqlSession sqlSession) {
		SqlSessionUtils.closeSqlSession(sqlSession, GlobalConfigUtils.currentSessionFactory(currentModelClass()));
	}

	/**
	 * SqlStatement
	 *
	 * @param sqlMethod ignore
	 * @return ignore
	 */
	protected String sqlStatement(SqlMethod sqlMethod) {
		return SqlHelper.table(currentModelClass()).getSqlStatement(sqlMethod.getMethod());
	}

	@Override
	public boolean insertBatch(Collection<T> entityList, int batchSize) {
		String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
		return executeBatch(entityList, batchSize, (sqlSession, entity) -> sqlSession.insert(sqlStatement, entity));
	}

	protected <E> boolean executeBatch(Collection<E> list, int batchSize, BiConsumer<SqlSession, E> consumer) {
		Assert.isFalse(batchSize < 1, "batchSize must not be less than one");
		return !CollectionUtils.isEmpty(list) && executeBatch(sqlSession -> {
			int size = list.size();
			int i = 1;
			for (E element : list) {
				consumer.accept(sqlSession, element);
				if ((i % batchSize == 0) || i == size) {
					sqlSession.flushStatements();
				}
				i++;
			}
		});
	}

	protected boolean executeBatch(Consumer<SqlSession> consumer) {
		SqlSessionFactory sqlSessionFactory = SqlHelper.sqlSessionFactory(currentModelClass());
		SqlSessionHolder sqlSessionHolder = (SqlSessionHolder) TransactionSynchronizationManager
				.getResource(sqlSessionFactory);
		boolean transaction = TransactionSynchronizationManager.isSynchronizationActive();
		if (sqlSessionHolder != null) {
			SqlSession sqlSession = sqlSessionHolder.getSqlSession();
			sqlSession.commit(!transaction);
		}
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		if (!transaction) {
			log.warn("SqlSession [" + sqlSession
					+ "] was not registered for synchronization because DataSource is not transactional");
		}
		try {
			consumer.accept(sqlSession);
			sqlSession.commit(!transaction);
			return true;
		} catch (Throwable t) {
			sqlSession.rollback();
			Throwable unwrapped = ExceptionUtil.unwrapThrowable(t);
			if (unwrapped instanceof RuntimeException) {
				MyBatisExceptionTranslator myBatisExceptionTranslator = new MyBatisExceptionTranslator(
						sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(), true);
				throw Objects.requireNonNull(
						myBatisExceptionTranslator.translateExceptionIfPossible((RuntimeException) unwrapped));
			}
			throw ExceptionUtils.mpe(unwrapped);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		return SqlHelper.retBool(baseMapper.deleteBatchIds(idList));
	}

	@Override
	public boolean updateBatchById(Collection<T> entityList, int batchSize) {
		String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
        return executeBatch(entityList, batchSize, (sqlSession, entity) -> {
            MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
            param.put(Constants.ENTITY, entity);
            sqlSession.update(sqlStatement, param);
        });
	}

	@Override
	public List<T> listByIds(Collection<? extends Serializable> idList) {		
		return baseMapper.selectBatchIds(idList);
	}

	@Override
	public T getOne(Wrapper<T> queryWrapper) {
		return baseMapper.selectOne(queryWrapper);
	}

	@Override
	public int count(Wrapper<T> queryWrapper) {
		return baseMapper.selectCount(queryWrapper);
	}

	@Override
	public List<T> list(Wrapper<T> queryWrapper) {
		return baseMapper.selectList(queryWrapper);
	}

	@Override
	public <E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper) {
		return baseMapper.selectPage(page, queryWrapper);
	}

}
