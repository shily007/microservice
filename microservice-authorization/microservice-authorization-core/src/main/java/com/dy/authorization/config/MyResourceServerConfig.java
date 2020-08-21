package com.dy.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.dy.authorization.filter.MyOncePerRequestFilter;
import com.dy.authorization.properties.SecurityConstants;

/**
 * 资源服务器
 * 
 * @author dy
 *
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

//	@Autowired
//	private SecurityProperties securityProperties;
	@Autowired
	private MyOncePerRequestFilter myOncePerRequestFilter;
	@Autowired
	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;	
	@Autowired
	protected AuthenticationFailureHandler myAuthenticationFailureHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)//登录提交表单
				.successHandler(myAuthenticationSuccessHandler)//登录成功处理器
				.failureHandler(myAuthenticationFailureHandler)//登录失败处理器
				.permitAll()
				.and()
			.authorizeRequests()
				.antMatchers(//配置不需要拦截的URI
						SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM,"/swagger-ui.html", "/**/*.css", "/**/*.js","/publicKey", "/actuator", 
						"/actuator/**", "/", "/turbine/*", "/turbine.*", "/**/hystrix.**", "/hystrix/**",
						"/**/*.ico", "hystrix.stream&title=sys-consumer","/actuator/hystrix.stream")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
			.addFilterBefore(myOncePerRequestFilter, AbstractPreAuthenticatedProcessingFilter.class)
			.csrf()
				.disable();
//		securityProperties.getUn_auth_uris()
	}

}
