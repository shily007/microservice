package com.dy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.dy.utils.jasypt.JasyptConstants;

/**
 * @author GongXincheng
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@EnableDiscoveryClient
public class Application_Hystrix_Dashboard_Server {

    public static void main(String[] args) {
    	System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
        SpringApplication.run(Application_Hystrix_Dashboard_Server.class, args);
    }

}
