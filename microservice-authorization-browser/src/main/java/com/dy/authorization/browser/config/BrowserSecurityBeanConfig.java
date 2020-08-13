/**
 * 
 */
package com.dy.authorization.browser.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.web.client.RestTemplate;

import com.dy.authorization.browser.session.MyExpiredSessionStrategy;

/**
 * 
 * @author Administrator
 *
 */
@Configuration
public class BrowserSecurityBeanConfig {

	
	@Bean
	@ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
		return new MyExpiredSessionStrategy();
	}

	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
