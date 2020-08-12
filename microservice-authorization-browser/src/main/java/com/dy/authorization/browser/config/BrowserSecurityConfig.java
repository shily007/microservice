package com.dy.authorization.browser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.dy.authorization.browser.handler.MyLogoutSuccessHandler;
import com.dy.authorization.browser.session.MyExpiredSessionStrategy;
import com.dy.authorization.properties.SecurityConstants;
import com.dy.authorization.properties.SecurityProperties;
/**
 * 校验码相关配置
 * @author Administrator
 *
 */
@Configuration
public class BrowserSecurityConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private UserDetailsService userDetailsService;
//	@Autowired
//	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
//	@Autowired
//	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
//	@Autowired
//	private SpringSocialConfigurer mySocialSecurityConfig;
	@Autowired
	private MyLogoutSuccessHandler logoutSuccessHandler;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {	
		http
		.formLogin().successForwardUrl("/")
		.failureForwardUrl("/login")
		.and()
//			.apply(validateCodeSecurityConfig)
//				.and()
//			.apply(smsCodeAuthenticationSecurityConfig)
//				.and()
//			.apply(mySocialSecurityConfig)
//				.and()
			//浏览器特有配置
			.rememberMe()//记住我
//				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailsService)
//		http.httpBasic()
				.and()
			.sessionManagement()
				.invalidSessionUrl(securityProperties.getBrowser().getSession().getSessionInvalidUrl())
				.maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
				.maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
				.expiredSessionStrategy(new MyExpiredSessionStrategy())
				.and()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.logoutSuccessHandler(logoutSuccessHandler)
				.deleteCookies("JSESSIONID")
				.and()
			.authorizeRequests()
				.antMatchers(
//						SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
						SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
//						SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
						securityProperties.getBrowser().getLoginPage(),
						securityProperties.getBrowser().getSignUpUrl(),
						SecurityConstants.DEFAULT_SESSION_INVALID_URL,
						"/login").permitAll()//不需要验证的页面
				.anyRequest()
				.authenticated()
				.and()
			.csrf().disable();//关闭csrf防护
	}

}
