package com.dy.student.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.dy.api.base.BaseService;
import com.dy.student.entity.Student;
import com.dy.student.fallback.StudentServiceFallback;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dy
 * @since 2020-09-22
 */
@FeignClient(value = "STUDENT-API",fallback = StudentServiceFallback.class)
public interface StudentService extends BaseService<Student> {
	
}
