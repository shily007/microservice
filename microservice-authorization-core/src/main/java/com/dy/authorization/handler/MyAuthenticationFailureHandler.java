package com.dy.authorization.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.dy.api.utils.JsonResult;
import com.dy.authorization.properties.LoginType;
import com.dy.authorization.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 登录失败处理器
 * 
 * @author dy
 *
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private Logger logger;
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		logger.info("登录失败！");
		String msg = exception.getMessage();
		if (securityProperties.getLoginType() == LoginType.JSON) {
			response.setStatus(HttpStatus.OK.value());
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(new JsonResult<>(msg)));
		}else {
			super.onAuthenticationFailure(request, response, exception);
		}
	}

}
