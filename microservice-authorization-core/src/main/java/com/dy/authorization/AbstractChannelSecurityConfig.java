package com.dy.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.dy.authorization.properties.SecurityProperties;

/**
 * 登录相关配置
 * @author Administrator
 *
 */
//public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;	
//	@Autowired
//	protected AuthenticationFailureHandler myAuthenticationFailureHandler;
//	@Autowired
//	protected SecurityProperties securityProperties;
//	
//	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
//		http.formLogin()
//			.loginProcessingUrl(securityProperties.getBrowser().getLoginUrl())//登录提交表单
//			.successHandler(myAuthenticationSuccessHandler)//登录成功处理器
//			.failureHandler(myAuthenticationFailureHandler)//登录失败处理器
//			.successForwardUrl(securityProperties.getBrowser().getLoginSuccessUrl())
//			.failureForwardUrl(securityProperties.getBrowser().getLoginUrl());
//	}
//	
//}
