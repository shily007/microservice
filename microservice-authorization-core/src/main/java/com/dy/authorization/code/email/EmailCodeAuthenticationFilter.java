package com.dy.authorization.code.email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import com.dy.authorization.properties.SecurityConstants;

/**
 * @Title EmailCodeAuthenticationFilter
 * @Description  邮箱验证码登录的过滤器
 * @author dy
 * @date 2019年12月3日
 */
public class EmailCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public static final String SPRING_SECURITY_FORM_EMAIL_KEY = "email";
	private String emailParameter = SPRING_SECURITY_FORM_EMAIL_KEY;
	private boolean postOnly = true;

	// ~ Constructors
	// ===================================================================================================

	public EmailCodeAuthenticationFilter() {
		super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_EMAIL, "POST"));
	}

	// ~ Methods
	// ========================================================================================================

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		String email = obtainEmailParameter(request);
		if (email == null) 
			email = "";		
		email = email.trim();

		EmailCodeAuthenticationToken authRequest = new EmailCodeAuthenticationToken(email);

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * Enables subclasses to override the composition of the username, such as by
	 * including additional values and a separator.
	 *
	 * @param request so that request attributes can be retrieved
	 *
	 * @return the username that will be presented in the
	 *         <code>Authentication</code> request token to the
	 *         <code>AuthenticationManager</code>
	 */
	protected String obtainEmailParameter(HttpServletRequest request) {
		return request.getParameter(emailParameter);
	}

	/**
	 * Provided so that subclasses may configure what is put into the authentication
	 * request's details property.
	 *
	 * @param request     that an authentication request is being created for
	 * @param authRequest the authentication request object that should have its
	 *                    details set
	 */
	protected void setDetails(HttpServletRequest request, EmailCodeAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	/**
	 * Sets the parameter name which will be used to obtain the username from the
	 * login request.
	 *
	 * @param usernameParameter the parameter name. Defaults to "username".
	 */
	public void setEmailParameter(String emailParameter) {
		Assert.hasText(emailParameter, "Username parameter must not be empty or null");
		this.emailParameter = emailParameter;
	}

	/**
	 * Defines whether only HTTP POST requests will be allowed by this filter. If
	 * set to true, and an authentication request is received which is not a POST
	 * request, an exception will be raised immediately and authentication will not
	 * be attempted. The <tt>unsuccessfulAuthentication()</tt> method will be called
	 * as if handling a failed authentication.
	 * <p>
	 * Defaults to <tt>true</tt> but may be overridden by subclasses.
	 */
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	public final String getMobileParameter() {
		return emailParameter;
	}

}
