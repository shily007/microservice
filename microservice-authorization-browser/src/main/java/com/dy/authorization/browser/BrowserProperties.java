package com.dy.authorization.browser;

public class BrowserProperties {
	
	private String signUpUrl = "/signUp.html";
	private String loginPage = "/signIn.html";
	private String logoutUrl = "/logout";
	private LoginType loginType = LoginType.JSON;
	private int rememberMeSeconds = 3*24*60*60;
	private SessionProperties session = new SessionProperties();
	private String loginUrl = "/login";
	private String loginSuccessUrl = "/";
	private String logoutSuccessUrl = "/login";
	private String logoutPage = "/logout.html";
	
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
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getLoginSuccessUrl() {
		return loginSuccessUrl;
	}
	public void setLoginSuccessUrl(String loginSuccessUrl) {
		this.loginSuccessUrl = loginSuccessUrl;
	}
	public String getLogoutSuccessUrl() {
		return logoutSuccessUrl;
	}
	public void setLogoutSuccessUrl(String logoutSuccessUrl) {
		this.logoutSuccessUrl = logoutSuccessUrl;
	}
	public String getLogoutPage() {
		return logoutPage;
	}
	public void setLogoutPage(String logoutPage) {
		this.logoutPage = logoutPage;
	}

}
