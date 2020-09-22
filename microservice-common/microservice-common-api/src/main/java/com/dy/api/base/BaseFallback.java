package com.dy.api.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 
 * 
 * @param <T>
 * @author dy
 * 2020年9月22日
 */
public class BaseFallback<T> implements BaseService<T> {

	@Override
	public boolean insertBatch(Collection<T> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<T> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> listByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getOne(Wrapper<T> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Wrapper<T> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> list(Wrapper<T> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

}
