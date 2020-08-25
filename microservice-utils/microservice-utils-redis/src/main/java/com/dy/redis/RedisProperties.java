package com.dy.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisProperties {
	
    private String host;
    private int port;
    private int expireSeconds;
    private List<String> clusterNodes = new ArrayList<String>();
    private String password;
    private int commandTimeout;

}
