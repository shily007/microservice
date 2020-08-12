package com.dy.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.dy.authorization.filter.ActionFilter;
import com.dy.authorization.filter.AuthCodeFilter;
import com.dy.authorization.properties.SecurityConstants;
import com.dy.authorization.properties.SecurityProperties;

/**
 * 资源服务器
 * 
 * @author dy
 *
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private ActionFilter actionFilter;
	@Autowired
	private AuthCodeFilter authCodeFilter;
	@Autowired
	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;	
	@Autowired
	protected AuthenticationFailureHandler myAuthenticationFailureHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
//		.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)//登录页面
		.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)//登录提交表单
		.successHandler(myAuthenticationSuccessHandler)//登录成功处理器
		.failureHandler(myAuthenticationFailureHandler)//登录失败处理器
		.and()
		.addFilterBefore(actionFilter, AbstractPreAuthenticatedProcessingFilter.class)
		.addFilterBefore(authCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
		
		http
//			.apply(validateCodeSecurityConfig)
//				.and()
//			.apply(smsCodeAuthenticationSecurityConfig)
//				.and()
//			.apply(mySocialSecurityConfig)
//				.and()
			.authorizeRequests()
				.antMatchers(
//						SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
						SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
//						SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
						securityProperties.getBrowser().getLoginPage(),
						securityProperties.getBrowser().getSignUpUrl(),
						SecurityConstants.DEFAULT_SESSION_INVALID_URL,
						"/user/regist","social/signUp").permitAll()//不需要验证的页面
				.anyRequest()
				.authenticated()
				.and()
			.csrf().disable();//关闭csrf防护
	}

}
