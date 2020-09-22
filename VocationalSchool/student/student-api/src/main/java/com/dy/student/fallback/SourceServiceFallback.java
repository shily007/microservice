package com.dy.student.fallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.student.entity.Source;
import com.dy.student.service.SourceService;

import feign.hystrix.FallbackFactory;
/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
@Component
public class SourceServiceFallback implements FallbackFactory<SourceService> {

	@Override
	public SourceService create(Throwable cause) {
		return new SourceService () {

			@Override
			public boolean insertBatch(Collection<Source> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean updateBatchById(Collection<Source> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Source> listByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Source getOne(Wrapper<Source> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int count(Wrapper<Source> queryWrapper) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<Source> list(Wrapper<Source> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <E extends IPage<Source>> E page(E page, Wrapper<Source> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
