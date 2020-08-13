package com.dy.authorization.browser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.dy.authorization.browser.SecurityConstants;
import com.dy.authorization.browser.SecurityProperties;
import com.dy.authorization.browser.session.MyExpiredSessionStrategy;

//@Configuration
//@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
	protected AuthenticationFailureHandler myAuthenticationFailureHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
//            .antMatchers("/resources/**", "/signup", "/about").permitAll()
//            .antMatchers("/admin/**").hasRole("ADMIN")
//            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
            .anyRequest().authenticated()
            .and()
        .formLogin()
	        .successHandler(myAuthenticationSuccessHandler)// 登录成功处理器
			.failureHandler(myAuthenticationFailureHandler)
            .usernameParameter("username")
            .passwordParameter("password")           
            .failureForwardUrl("/login?error")
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .permitAll()
            .and()
        .httpBasic()
            .disable();
	}

}
