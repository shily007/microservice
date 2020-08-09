package com.dy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

import com.dy.utils.jasypt.JasyptConstants;

/**
 * 注冊中心
 * 
 * @author dy
 *
 */
@SpringBootApplication
@EnableEurekaServer
@EnableAutoConfiguration
@Configuration
public class Application_Eureka_Server {

	public static void main(String[] args) throws Exception {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Eureka_Server.class, args);
	}

}
