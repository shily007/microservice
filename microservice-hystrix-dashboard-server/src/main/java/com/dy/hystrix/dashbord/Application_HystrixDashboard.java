package com.dy.hystrix.dashbord;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author GongXincheng
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@EnableDiscoveryClient
public class Application_HystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(Application_HystrixDashboard.class, args);
    }

}
