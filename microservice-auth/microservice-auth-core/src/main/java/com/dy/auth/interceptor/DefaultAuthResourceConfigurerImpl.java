package com.dy.auth.interceptor;

import org.springframework.stereotype.Component;

@Component
public class DefaultAuthResourceConfigurerImpl implements AuthResourceConfigurer {

	@Override
	public void configure(HttpAuth http) {
		http.loginProcessingUrl("/authentication/form")//登录地址
			.antMatchers("/authentication/form1");//不需要拦截的uri
	}

}
