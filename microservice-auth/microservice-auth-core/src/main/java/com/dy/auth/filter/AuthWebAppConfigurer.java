package com.dy.auth.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author dy
 *
 */
@Configuration
public class AuthWebAppConfigurer {
	
	@Autowired
	private AuthFilter authFilter;

	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegist() {
		FilterRegistrationBean<AuthFilter> frBean = new FilterRegistrationBean<>();
		frBean.setFilter(authFilter);
//        frBean.setOrder(1);//多个过滤器时指定过滤器的执行顺序
		frBean.addUrlPatterns("/*");
		System.out.println("filter");
		return frBean;
	}

}
