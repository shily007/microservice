package com.dy.zookeeper.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 注入zookeeper的配置信息
 * 
 * @author dy 2020年9月8日
 */
@Data
@Component
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {

	// 每次重试时间间隔，单位毫秒
	private int baseSleepTimeMs;
	//重试次数
	private int maxRetries;
	// zookeeper服务连接id与端口
	private String connectString;
	// 会话超时时间，单位毫秒
	private int sessionTimeoutMs;
	// 连接创建超时时间，单位毫秒
	private int connectionTimeoutMs;

}
