//package com.dy.authorization.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//
//import com.dy.authorization.filter.ActionFilter;
//import com.dy.authorization.properties.LoginType;
//import com.dy.authorization.properties.SecurityConstants;
//import com.dy.authorization.properties.SecurityProperties;
//
///**
// * 资源服务器
// * 
// * @author dy
// *
// */
//@Configuration
//@EnableResourceServer
//public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//	@Autowired
//	private SecurityProperties securityProperties;
//	@Autowired
//	private ActionFilter actionFilter;
//	@Autowired
//	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;	
//	@Autowired
//	protected AuthenticationFailureHandler myAuthenticationFailureHandler;
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		if (securityProperties.getLoginType() == LoginType.JSON) {//app登录
//			http
//				.formLogin()
//					.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)//登录提交表单
//					.successHandler(myAuthenticationSuccessHandler)//登录成功处理器
//					.failureHandler(myAuthenticationFailureHandler)//登录失败处理器
//					.permitAll()
//					.and()
//				.authorizeRequests()
//					.antMatchers(//配置不需要拦截的URI
//							SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
//					.permitAll()
//					.anyRequest()
//					.authenticated();
//		} else {//浏览器登录
////			http
////				.formLogin()
////					.loginPage(securityProperties.getBrowser().getLoginPage())//登录页面
////					.loginProcessingUrl(securityProperties.getBrowser().getLoginUrl())//登录提交表单
////					.successForwardUrl(securityProperties.getBrowser().getLoginSuccessUrl())//登录成功
////					.failureForwardUrl(securityProperties.getBrowser().getLoginFailureUrl())//登录失败
////					.permitAll()
////					.and()
////				.logout()
////		            .logoutUrl(securityProperties.getBrowser().getLogoutUrl())
////		            .logoutSuccessUrl(securityProperties.getBrowser().getLogoutSuccessUrl())
////		            .permitAll()
////		            .and()
////		         .authorizeRequests()
////					.antMatchers(//配置不需要拦截的URI
////							securityProperties.getBrowser().getLoginPage(),
////							securityProperties.getBrowser().getSignUpUrl(),
////							securityProperties.getBrowser().getLoginUrl(),
////							securityProperties.getBrowser().getLoginFailureUrl(),
////							securityProperties.getBrowser().getLogoutPage())
////					.permitAll()//不需要验证的页面
////					.anyRequest()
////					.authenticated()
////					.and()
////		        .httpBasic()
////		            .disable();
//		}
//		for (int i = 0; i < securityProperties.getUn_auth_uris().length; i++) {
//			http
//				.authorizeRequests()
//					.antMatchers(securityProperties.getUn_auth_uris()[i])
//					.permitAll()//不需要验证的页面
//					.anyRequest()
//					.authenticated();
//		}
//		http
//			.authorizeRequests()
//				.antMatchers("/swagger-ui.html", "/**/*.css", "/**/*.js","/publicKey", "/actuator", 
//						"/actuator/**", "/", "/turbine/*", "/turbine.*", "/**/hystrix.**", "/hystrix/**",
//						"/**/*.ico", "hystrix.stream&title=sys-consumer")
//				.permitAll()//不需要验证的页面
//				.anyRequest()
//				.authenticated()
//				.and()
//			.addFilterBefore(actionFilter, AbstractPreAuthenticatedProcessingFilter.class)
//			.csrf()
//				.disable();//关闭csrf防护
//	}
//
//}
