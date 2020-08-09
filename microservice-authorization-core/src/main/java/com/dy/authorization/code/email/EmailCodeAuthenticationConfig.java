package com.dy.authorization.code.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.dy.authorization.handler.MyAuthenticationFailureHandler;
import com.dy.authorization.handler.MyAuthenticationSuccessHandler;

/**
 * 邮箱验证码登录配置文件
 * @author dy
 *
 */
@Component
public class EmailCodeAuthenticationConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		EmailCodeAuthenticationFilter authenticationFilter = new EmailCodeAuthenticationFilter();
		authenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		authenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
		authenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
		
		EmailCodeAuthenticationProvider authenticationProvider = new EmailCodeAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		http.authenticationProvider(authenticationProvider)
			.addFilterAfter(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
