package com.dy.zookeeper.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dy.zookeeper.properties.ZookeeperProperties;

/**
 * 
 * 
 * @author dy 2020年9月8日
 */
@Configuration
public class ZookeeperConfig {

	/**
	 * 获取 CuratorFramework 使用 curator 操作 zookeeper
	 * 
	 * @return
	 */
	@Bean(initMethod = "start")
	public CuratorFramework curatorFramework(ZookeeperProperties zookeeperProperties) {
		return CuratorFrameworkFactory.newClient(zookeeperProperties.getConnectString(),
				zookeeperProperties.getSessionTimeoutMs(), zookeeperProperties.getConnectionTimeoutMs(),
				new RetryNTimes(zookeeperProperties.getMaxRetries(), zookeeperProperties.getBaseSleepTimeMs()));
	}

}