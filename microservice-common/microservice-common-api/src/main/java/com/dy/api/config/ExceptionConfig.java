package com.dy.api.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.api.base.CommonErrorMsg;
import com.dy.api.utils.JsonResult;


/**
 * 全局异常处理
 * 
 * @author dy 2020年7月17日
 */
@ResponseBody
@ControllerAdvice//本身也是基于AOP实现的
public class ExceptionConfig {

	@ExceptionHandler(value = Exception.class)
	public JsonResult<Object> captrue(Exception e) {
		e.printStackTrace();
		return new JsonResult<>(CommonErrorMsg.FAIL);
	}

}
