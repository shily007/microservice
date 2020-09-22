package com.dy.student.service.impl;

import org.springframework.stereotype.Service;

import com.dy.api.base.BaseServiceImpl;
import com.dy.student.entity.Student;
import com.dy.student.mapper.StudentMapper;
import com.dy.student.service.StudentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dy
 * @since 2020-09-22
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentMapper, Student> implements StudentService {

}
