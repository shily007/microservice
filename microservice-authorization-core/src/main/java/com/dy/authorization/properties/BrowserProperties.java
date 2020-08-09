package com.dy.authorization.properties;

public class BrowserProperties {
	
	private String signUpUrl = "/signUp.html";
	private String loginPage = "/signIn.html";
	private String logoutUrl = "";
	private LoginType loginType = LoginType.JSON;
	private int rememberMeSeconds = 3*24*60*60;
	private SessionProperties session = new SessionProperties();

	public String getSignUpUrl() {
		return signUpUrl;
	}
	public void setSignUpUrl(String signUpUrl) {
		this.signUpUrl = signUpUrl;
	}
	public String getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	public LoginType getLoginType() {
		return loginType;
	}
	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}
	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	public SessionProperties getSession() {
		return session;
	}
	public void setSession(SessionProperties session) {
		this.session = session;
	}

}
