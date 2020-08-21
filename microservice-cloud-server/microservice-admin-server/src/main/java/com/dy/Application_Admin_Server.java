package com.dy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.dy.utils.jasypt.JasyptConstants;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@EnableAutoConfiguration
public class Application_Admin_Server {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Admin_Server.class, args);
	}

}
