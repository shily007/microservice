package com.dy.authorization.properties;

import lombok.Data;

/**
 * @Title SmsCodeProperties
 * @Description  
 * @author dy
 * @date 2019年11月26日
 */
@Data
public class SmsCodeProperties {
	
	private int length = 6;//验证码长度
	private int expireIn = 300;//过期时间（秒）
	private int interval = 60;//发送验证码时间间隔（秒）
	private int toplimit = 10;//每日发送上限
	private String url = "";//需要验证的url，多个地址使用英文逗号隔开
	
}
