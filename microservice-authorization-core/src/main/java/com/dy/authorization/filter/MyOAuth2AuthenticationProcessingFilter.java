package com.dy.authorization.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

@Component
public class MyOAuth2AuthenticationProcessingFilter extends OAuth2AuthenticationProcessingFilter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		try {
			HttpSession session = request.getSession();
			Authentication authentication = (Authentication) session.getAttribute("Authorization");
			request.setAttribute("Authorization", authentication);
		} catch (Exception e) {
		}
		super.doFilter(request, res, chain);
	}

}
