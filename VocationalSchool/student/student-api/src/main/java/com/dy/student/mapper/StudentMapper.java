package com.dy.student.mapper;

import com.dy.student.entity.Student;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dy
 * @since 2020-09-22
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
