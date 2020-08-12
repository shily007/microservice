package com.dy.authorization.browser.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.dy.api.utils.JsonResult;
import com.dy.authorization.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

	@Autowired
	private SecurityProperties securityProperties;
	private ObjectMapper objectMapper = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(Object.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		logger.info("退出成功！");
		if (StringUtils.isBlank(securityProperties.getBrowser().getLogoutUrl())) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(new JsonResult<>("退出成功！")));
		} else {
			response.sendRedirect(securityProperties.getBrowser().getLogoutUrl());
		}
	}

}
