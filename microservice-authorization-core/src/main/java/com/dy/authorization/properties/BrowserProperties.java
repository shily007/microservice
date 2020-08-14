package com.dy.authorization.properties;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BrowserProperties {
	
	private String signUpUrl = "/signUp.html";		
	private SessionProperties session = new SessionProperties();
	private String loginPage = "/signIn.html";	
	private String loginUrl = "/login";
	private String loginSuccessUrl = "/";
	private String loginFailureUrl = "/login?error";
	private String logoutUrl = "/logout";
	private String logoutSuccessUrl = "/login";
	private String logoutPage = "/logout.html";

}
