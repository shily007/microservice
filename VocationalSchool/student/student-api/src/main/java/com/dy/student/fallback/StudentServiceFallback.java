package com.dy.student.fallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.student.entity.Student;
import com.dy.student.service.StudentService;

import feign.hystrix.FallbackFactory;
/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
@Component
public class StudentServiceFallback implements FallbackFactory<StudentService> {

	@Override
	public StudentService create(Throwable cause) {
		return new StudentService() {

			@Override
			public boolean insertBatch(Collection<Student> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean updateBatchById(Collection<Student> entityList, int batchSize) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Student> listByIds(Collection<? extends Serializable> idList) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Student getOne(Wrapper<Student> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int count(Wrapper<Student> queryWrapper) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<Student> list(Wrapper<Student> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <E extends IPage<Student>> E page(E page, Wrapper<Student> queryWrapper) {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

}
