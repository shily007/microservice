package com.dy.auth.interceptor;

/**
 * 配置用户自定义信息
 * 
 * @author dy
 * 2020年12月16日
 */
public interface AuthResourceConfigurer {
	
	void configure(HttpAuth http);

}
