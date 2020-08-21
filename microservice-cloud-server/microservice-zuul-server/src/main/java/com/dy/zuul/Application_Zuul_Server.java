package com.dy.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.dy.utils.jasypt.JasyptConstants;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Application_Zuul_Server {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Zuul_Server.class, args);
	}

}