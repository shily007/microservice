package com.dy.zuul.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "com.dy.zuul")
@Component
public class ZuulProperties {
	
	/**
	 * 每秒产生的令牌数
	 */
	private int permitsPerSecond = 1000;
	/**
	 * 需要拦截的uri
	 */
	private List<String> interceptUris = new ArrayList<>();

}
