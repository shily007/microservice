package com.dy.authorization.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "com.dy.security", ignoreInvalidFields = true)
@Component
public class SecurityProperties {	
	
	private Oauth2Properties oauth2 = new Oauth2Properties();//oauth2配置
	private LoginType loginType = LoginType.JSON;//登录方式
	private int rememberMeSeconds = 3*24*60*60;//登录失效时间
	private BrowserProperties browser = new BrowserProperties();//浏览器配置
	private String[] un_auth_uris = {};//不需要验证的uri
	
}
