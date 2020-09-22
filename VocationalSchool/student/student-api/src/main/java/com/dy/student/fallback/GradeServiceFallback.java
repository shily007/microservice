package com.dy.student.fallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.student.entity.Grade;
import com.dy.student.service.GradeService;

import feign.hystrix.FallbackFactory;
/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
@Component
public class GradeServiceFallback implements FallbackFactory<GradeService> {

	@Override
	public GradeService create(Throwable cause) {
		return new GradeService() {

			@Override
			public boolean insertBatch(Collection<Grade> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean updateBatchById(Collection<Grade> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Grade> listByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Grade getOne(Wrapper<Grade> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int count(Wrapper<Grade> queryWrapper) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<Grade> list(Wrapper<Grade> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <E extends IPage<Grade>> E page(E page, Wrapper<Grade> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
