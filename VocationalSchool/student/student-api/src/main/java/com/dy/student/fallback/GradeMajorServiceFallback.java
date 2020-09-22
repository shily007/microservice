package com.dy.student.fallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.student.entity.GradeMajor;
import com.dy.student.service.GradeMajorService;

import feign.hystrix.FallbackFactory;
/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
@Component
public class GradeMajorServiceFallback implements FallbackFactory<GradeMajorService> {

	@Override
	public GradeMajorService create(Throwable cause) {
		return new GradeMajorService() {

			@Override
			public boolean insertBatch(Collection<GradeMajor> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean updateBatchById(Collection<GradeMajor> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<GradeMajor> listByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GradeMajor getOne(Wrapper<GradeMajor> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int count(Wrapper<GradeMajor> queryWrapper) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<GradeMajor> list(Wrapper<GradeMajor> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <E extends IPage<GradeMajor>> E page(E page, Wrapper<GradeMajor> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

}
