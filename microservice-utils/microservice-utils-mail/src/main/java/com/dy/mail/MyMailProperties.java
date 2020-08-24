package com.dy.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.dy.mail",ignoreInvalidFields = true)
@Component
public class MyMailProperties {
	
	/**
	 * 主题
	 */
	private String subject;
	/**
	 * 固定接收人群
	 */
	private String[] receivers;
	/**
	 * 单次最大群发数
	 */
	private int maxCount = 50;
	/**
	 * 发送失败重发次数
	 */
	private int retryCount = 3;
}
