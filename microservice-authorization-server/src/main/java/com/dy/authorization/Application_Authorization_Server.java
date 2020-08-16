package com.dy.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.dy.utils.jasypt.JasyptConstants;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class Application_Authorization_Server {
	
	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Authorization_Server.class, args);
	}
	
}
