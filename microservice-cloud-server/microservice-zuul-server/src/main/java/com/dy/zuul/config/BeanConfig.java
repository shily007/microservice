package com.dy.zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * bean配置
 * 
 * @author dy
 * 2020年8月19日
 */
@Component
public class BeanConfig {
	
	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(Object.class);
	}

}
