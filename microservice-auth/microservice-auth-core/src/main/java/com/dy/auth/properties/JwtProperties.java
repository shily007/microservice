package com.dy.auth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.dy.auth", ignoreInvalidFields = true)
@Component
public class JwtProperties {
	// 令牌过期时间
	private int TOKEN_EXP_TIME = 1000 * 60 * 60 * 2;
	// 签名
	private String JWT_SIGNING_KEY = "dy";
	
	public int getTOKEN_EXP_TIME() {
		return TOKEN_EXP_TIME;
	}
	public void setTOKEN_EXP_TIME(int tOKEN_EXP_TIME) {
		TOKEN_EXP_TIME = tOKEN_EXP_TIME;
	}
	public String getJWT_SIGNING_KEY() {
		return JWT_SIGNING_KEY;
	}
	public void setJWT_SIGNING_KEY(String jWT_SIGNING_KEY) {
		JWT_SIGNING_KEY = jWT_SIGNING_KEY;
	}

}
