package com.dy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class Application_Authorization_Server {
	
	public static void main(String[] args) {
		SpringApplication.run(Application_Authorization_Server.class, args);
	}
	
}
