package com.dy.student.fallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.student.entity.Major;
import com.dy.student.service.MajorService;

import feign.hystrix.FallbackFactory;
/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
@Component
public class MajorServiceFallback implements FallbackFactory<MajorService> {

	@Override
	public MajorService create(Throwable cause) {
		return new MajorService() {

			@Override
			public boolean insertBatch(Collection<Major> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean updateBatchById(Collection<Major> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Major> listByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Major getOne(Wrapper<Major> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int count(Wrapper<Major> queryWrapper) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<Major> list(Wrapper<Major> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <E extends IPage<Major>> E page(E page, Wrapper<Major> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
