package com.dy.api.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

public interface BaseService<T> {

	/**
	 * 默认一次批量保存数据的条数
	 */
	int DEFAULT_BATCH_SIZE = 1000;

	/**
	 * insert
	 * 
	 * @param entity
	 * @return
	 * @author dy 2020年9月22日
	 */
	@PostMapping("insert")
	default boolean insert(T entity) {
		return insertBatch(Arrays.asList(entity));
	}

	/**
	 * 批量插入 insertBatch
	 * 
	 * @param entityList
	 * @return
	 * @author dy 2020年9月22日
	 */
	@Transactional(rollbackFor = Exception.class)
	@PostMapping("insertBatch")
	default boolean insertBatch(Collection<T> entityList) {
		return insertBatch(entityList, DEFAULT_BATCH_SIZE);
	}

	/**
	 * 批量插入 insertBatch
	 * 
	 * @param entityList
	 * @param batchSize
	 * @return
	 * @author dy 2020年9月22日
	 */
	@PostMapping("insertBatch/batchSize")
	boolean insertBatch(Collection<T> entityList, int batchSize);

	/**
	 * 根据id删除 removeById
	 * 
	 * @param id
	 * @return
	 * @author dy 2020年9月22日
	 */
	@DeleteMapping("removeById")
	default boolean removeById(Serializable id) {
		return removeByIds(Arrays.asList(id));
	}

	/**
	 * 根据id批量删除 removeByIds
	 * 
	 * @param idList
	 * @return
	 * @author dy 2020年9月22日
	 */
	@DeleteMapping("removeByIds")
	boolean removeByIds(Collection<? extends Serializable> idList);

	/**
	 * 根据id修改 updateById
	 * 
	 * @param entity
	 * @return
	 * @author dy 2020年9月22日
	 */
	@PutMapping("updateById")
	default boolean updateById(T entity) {
		return updateBatchById(Arrays.asList(entity));
	}

	/**
	 * 根据id批量修改 updateBatchById
	 * 
	 * @param entityList
	 * @return
	 * @author dy 2020年9月22日
	 */
	@Transactional(rollbackFor = Exception.class)
	@PutMapping("updateBatchById")
	default boolean updateBatchById(Collection<T> entityList) {
		return updateBatchById(entityList, DEFAULT_BATCH_SIZE);
	}

	/**
	 * 根据id批量修改 updateBatchById
	 * 
	 * @param entityList
	 * @param batchSize
	 * @return
	 * @author dy 2020年9月22日
	 */
	@PutMapping("updateBatchById/size")
	boolean updateBatchById(Collection<T> entityList, int batchSize);

	/**
	 * 根据id查询 getById
	 * 
	 * @param id
	 * @return
	 * @author dy 2020年9月22日
	 */
	@Transactional(rollbackFor = Exception.class)
	@GetMapping("getById")
	default T getById(Serializable id) {
		return listByIds(Arrays.asList(id)).get(0);
	}

	/**
	 * 根据id集合查询 listByIds
	 * 
	 * @param idList
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("listByIds")
	List<T> listByIds(Collection<? extends Serializable> idList);

	/**
	 * 根据条件查询唯一 getOne
	 * 
	 * @param queryWrapper
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("getOne")
	T getOne(Wrapper<T> queryWrapper);

	/**
	 * 
	 * count
	 * 
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("count")
	default int count() {
		return count(Wrappers.emptyWrapper());
	}

	/**
	 * 
	 * count
	 * 
	 * @param queryWrapper
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("count/wrapper")
	int count(Wrapper<T> queryWrapper);

	/**
	 * 
	 * list
	 * 
	 * @param queryWrapper
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("list")
	List<T> list(Wrapper<T> queryWrapper);

	/**
	 * 
	 * page
	 * 
	 * @param <E>
	 * @param page
	 * @param queryWrapper
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("page/wrapper")
	<E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper);

	/**
	 * 
	 * page
	 * 
	 * @param <E>
	 * @param page
	 * @return
	 * @author dy 2020年9月22日
	 */
	@GetMapping("page")
	default <E extends IPage<T>> E page(E page) {
		return page(page, Wrappers.emptyWrapper());
	}

}
