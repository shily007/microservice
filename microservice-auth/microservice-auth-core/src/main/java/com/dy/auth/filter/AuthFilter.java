package com.dy.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dy.auth.JwtUtils;
import com.dy.auth.exception.AuthException;
import com.dy.auth.exception.TokenInvalidException;
import com.dy.auth.exception.TokenNullException;
import com.dy.auth.interceptor.AuthResourceConfigurer;
import com.dy.auth.interceptor.AuthUser;
import com.dy.auth.interceptor.AuthUserService;
import com.dy.auth.interceptor.HttpAuth;
import com.dy.auth.util.PasswordUtil;
import com.dy.auth.util.RSAUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * 拦截请求获取token并验证
 * 
 * @author dy 2020年12月16日
 */
@Component
public class AuthFilter extends OncePerRequestFilter {

	private final static String ACCESS_TOKEN = "access_token";
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	private HttpAuth http = null;
	@Autowired
	private AuthResourceConfigurer authResourceConfigurer;
	@Autowired(required = false)
	private AuthUserService authUserService;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (http == null) {
			synchronized (this.getClass()) {
				if(http == null) {
					http = HttpAuth.getHttpAuth();
					authResourceConfigurer.configure(http);
				}
			}
		}
		String uri = request.getRequestURI();
		if (uri.equals(http.getLoginProcessingUrl())) {
			login(request, response);
		} else {
			// 判断请求路径是否需要登录验证
			if (uriIsAuth(uri)) {
				String token = getToken(request);// 从 http 请求头中取出 token
				if (!StringUtils.isNotBlank(token)) {
					throw new TokenNullException("token is null");
				}
				try {
					token = RSAUtil.decrypt(token);
//				Claims claims = 
					JwtUtils.parseJWT(token);
				} catch (ExpiredJwtException e) {
					throw new TokenInvalidException("token is expired");
				} catch (Exception e) {
					throw new TokenInvalidException("token is invalid");
				}
			}
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * 登录 login
	 * 
	 * @param request
	 * @param response
	 * @author dy 2020年12月17日
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String loginType = request.getParameter("loginType");
		AuthUser user = null;
		if (StringUtils.isNotBlank(loginType)) {
			String openid = request.getParameter("openid");
			user = authUserService.loadByOpenid(openid, loginType);
			if (user == null) {
				throw new AuthException("user does not exist");
			}
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!StringUtils.isNotBlank(username) || !StringUtils.isNotBlank(password)) {
				throw new AuthException("username and password must not null");
			}
			user = authUserService.loadByUsernamer(username);
			if (user == null) {
				throw new AuthException("user does not exist");
			}
			if (!PasswordUtil.comparePassword(username, password, user.getPassword())) {
				throw new AuthException("username or password error");
			}
		}
		if (user.isAccountNonExpired()) {
			throw new AuthException("user expired");
		}
		if (user.isAccountNonLocked()) {
			throw new AuthException("user locked");
		}
		if (!user.isEnabled()) {
			throw new AuthException("user not enabled");
		}
		String token = jwtUtils.createJWT(user.getUsername(), "");
		token = RSAUtil.encrypt(token);
		try {
			response.getWriter().write(objectMapper.writeValueAsString("{'access_token':" + token + "}"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断请求地址是否需要登录验证 uriIsAuth
	 * 
	 * @param uri
	 * @return
	 * @author dy 2020年12月17日
	 */
	private boolean uriIsAuth(String uri) {
		for (String regex : http.getIgnore_uris()) {
			if (antPathMatcher.match(regex, uri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 从 http 请求头中取出 token getToken
	 * 
	 * @param request
	 * @return
	 * @author dy 2020年12月16日
	 */
	private String getToken(HttpServletRequest request) {
		String token = request.getHeader(ACCESS_TOKEN);// 先从header取token
		if (!StringUtils.isNotBlank(token)) {// 如果token为null，再从请求参数中取
			token = request.getParameter(ACCESS_TOKEN);
		}
		return token;
	}

}
