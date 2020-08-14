package com.dy.admin.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 校验码相关配置
 * 
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
//	@Autowired
//	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;
//	@Autowired
//	protected AuthenticationFailureHandler myAuthenticationFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService);
	}

	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(Object.class);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/resources/**", "/signup", "/about","/instances/**").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
            .anyRequest().authenticated()
            .and()
        .formLogin()
//	        .successHandler(myAuthenticationSuccessHandler)// 登录成功处理器
//			.failureHandler(myAuthenticationFailureHandler)
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
            .disable()
            .csrf().disable();
	}

}
