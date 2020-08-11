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
	private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler myAuthenticationFailureHandler;
	@Autowired
	private ActionFilter actionFilter;
	@Autowired
	private AuthCodeFilter authCodeFilter;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
//		.loginProcessingUrl("/authentication/form")
				.loginPage("/login").successHandler(myAuthenticationSuccessHandler)
				.failureHandler(myAuthenticationFailureHandler).and()
				.addFilterBefore(actionFilter, AbstractPreAuthenticatedProcessingFilter.class)
				.addFilterBefore(authCodeFilter, AbstractPreAuthenticatedProcessingFilter.class).logout()
				.logoutUrl("/logout");
		http.authorizeRequests()
				// 不需要验证的页面
//				.antMatchers("/code/*", "/swagger-ui.html", "/**/*.css", "/**/*.js", "/**/*.css?*", "**.js?*",
//						"/**/*.html", "/swagger*/**", "/webjars/**", "/v2/**", "/file/**", "/show/**", "/publicKey",
//						"/validateCode/**", "/signUp.html", SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
//						"/qqLogin/**", "/actuator", "/actuator/**", "/", "/turbine/*", "/turbine.*", "/**/hystrix.**",
//						"/hystrix/*", "/**/*.*.js", "/**/*.ico", "hystrix.stream&title=sys-consumer", "/login",
//						SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_EMAIL)
		.antMatchers("/login")
				.permitAll().anyRequest().authenticated().and().csrf().disable();

//		http.authorizeRequests().antMatchers("/assets/**").permitAll().antMatchers("/login").permitAll().anyRequest()
//				.authenticated().and().formLogin().loginPage("/login").successHandler(myAuthenticationSuccessHandler)
//				.failureHandler(myAuthenticationFailureHandler).and().logout().logoutUrl("/logout").and().httpBasic()
//				.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				.ignoringAntMatchers("/instances", "/instances/**", "/actuator/**");
	}

}
