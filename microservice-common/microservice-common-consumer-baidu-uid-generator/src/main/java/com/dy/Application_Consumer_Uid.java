package com.dy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.dy.utils.jasypt.JasyptConstants;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableHystrix
@MapperScan("com.baidu.fsg.uid")
public class Application_Consumer_Uid {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Consumer_Uid.class, args);
	}

}
