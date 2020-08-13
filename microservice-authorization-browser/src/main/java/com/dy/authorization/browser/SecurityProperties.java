package com.dy.authorization.browser;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.dy.security", ignoreInvalidFields = true)
@Component
public class SecurityProperties {	
	
	private BrowserProperties browser = new BrowserProperties();
	private Oauth2Properties oauth2 = new Oauth2Properties();
	
	public BrowserProperties getBrowser() {
		return browser;
	}
	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}
	public Oauth2Properties getOauth2() {
		return oauth2;
	}
	public void setOauth2(Oauth2Properties oauth2) {
		this.oauth2 = oauth2;
	}
	
}
