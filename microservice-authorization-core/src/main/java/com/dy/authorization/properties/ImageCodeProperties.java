package com.dy.authorization.properties;

import lombok.Data;

/**
 * @Title SmsCodeProperties
 * @Description  
 * @author dy
 * @date 2019年11月26日
 */
@Data
public class ImageCodeProperties {
	
	private int length = 6;//验证码长度
	private int expireIn = 300;//过期时间（秒）
	private String url = "";//需要验证的url，多个地址使用英文逗号隔开
	private int width = 67;//宽
	private int height = 23;//高
	
}
