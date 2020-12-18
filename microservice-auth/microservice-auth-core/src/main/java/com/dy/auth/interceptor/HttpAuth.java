package com.dy.auth.interceptor;

import java.util.ArrayList;
import java.util.List;


public class HttpAuth {
	
	private String loginProcessingUrl;
	private List<String> ignore_uris = new ArrayList<>();
	private static HttpAuth http = new HttpAuth();
	
	private HttpAuth() {
		super();
	}
	
	public static HttpAuth getHttpAuth() {
		return http;
	}
	
	public HttpAuth loginProcessingUrl(String loginProcessingUrl) {
		this.loginProcessingUrl = loginProcessingUrl;
		return this;
	}
	
	public HttpAuth antMatchers(String... ignoreUris) {
		for (String uri : ignoreUris) {
			ignore_uris.add(uri);
		}
		return this;
	}
	
	public String getLoginProcessingUrl() {
		return loginProcessingUrl;
	}
	
	public List<String> getIgnore_uris() {
		return ignore_uris;
	}
	
}
