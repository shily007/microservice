package com.dy.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

import com.netflix.loadbalancer.IRule;

@Configuration
public class ConfigBean { // boot -->spring applicationContext.xml --- @Configuration配置 ConfigBean =
							// applicationContext.xml

	@Primary
	@LoadBalanced
	@Bean // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		//return new RoundRobinRule();
		//return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
		return new MyRule();
	}
	
	/**
	 * RequestContextListener监听器
	 * requestContextListener
	 * @return
	 * @author dy
	 * 2020年8月4日
	 */
	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
	
}
