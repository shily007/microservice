package com.dy.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注冊中心
 * @author dy
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class Application_Eureka_Server {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application_Eureka_Server.class, args);
	}
	
}
