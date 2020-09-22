package com.dy.student.fallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.student.entity.MajorType;
import com.dy.student.service.MajorTypeService;

import feign.hystrix.FallbackFactory;
/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
@Component
public class MajorTypeServiceFallback implements FallbackFactory<MajorTypeService> {

	@Override
	public MajorTypeService create(Throwable cause) {
		return new MajorTypeService() {

			@Override
			public boolean insertBatch(Collection<MajorType> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean updateBatchById(Collection<MajorType> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<MajorType> listByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public MajorType getOne(Wrapper<MajorType> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int count(Wrapper<MajorType> queryWrapper) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<MajorType> list(Wrapper<MajorType> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <E extends IPage<MajorType>> E page(E page, Wrapper<MajorType> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

}
