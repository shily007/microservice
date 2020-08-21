package com.dy.authorization.properties;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Title Oauth2Properties
 * @Description  
 * @author dy
 * @date 2019年12月5日
 */@Data
@Accessors(chain = true)
public class Oauth2Properties {
	
	private Oauth2ClientProperties[] clients = {};
	private String jwtSigningKey = "dy"; //签名
	

}
