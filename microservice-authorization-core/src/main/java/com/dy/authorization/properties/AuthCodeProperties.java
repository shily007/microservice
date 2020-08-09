package com.dy.authorization.properties;

import lombok.Data;

/**
 * @Title AuthCodeProperties
 * @Description  
 * @author dy
 * @date 2019年11月26日
 */
@Data
public class AuthCodeProperties {
	
	SmsCodeProperties sms = new SmsCodeProperties();
	ImageCodeProperties image = new ImageCodeProperties();
	EmailCodeProperties email = new EmailCodeProperties();
	
}