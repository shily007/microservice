package com.dy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.dy.utils.jasypt.JasyptConstants;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
public class Application_Uid_Server {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Uid_Server.class, args);
	}

}
