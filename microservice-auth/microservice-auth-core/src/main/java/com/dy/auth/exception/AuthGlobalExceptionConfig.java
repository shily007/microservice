package com.dy.auth.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.api.utils.JsonResult;

/**
 * 全局异常处理
 * @author dy
 *
 */
@ResponseBody
@ControllerAdvice
public class AuthGlobalExceptionConfig {
	
	@ExceptionHandler(value = AuthException.class)
	public JsonResult<Object> login(AuthException e) {
		return new JsonResult<>(e.getMessage());
	}
	
	@ExceptionHandler(value = TokenNullException.class)
	public JsonResult<Object> tokenNull(TokenNullException e) {
		return new JsonResult<>("token must not null");
	}
	
	@ExceptionHandler(value = TokenInvalidException.class)
	public JsonResult<Object> tokenInvalid(TokenInvalidException e) {
		return new JsonResult<>("token invalid");
	}

}
