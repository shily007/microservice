package com.dy.authorization.handler;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.websocket.AuthenticationException;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.dy.api.utils.JsonResult;
import com.dy.authorization.properties.LoginType;
import com.dy.authorization.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 登录成功处理器
 * 
 * @author dy
 *
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private ClientDetailsService clientDetailsService;
	@Autowired
	private AuthorizationServerTokenServices authorizationServerTokenServices;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private Logger logger;
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		logger.info("登录成功！");
		if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {			
			response.setContentType("application/json;charset=UTF-8");
		}
		try {
			String header = request.getHeader("Authorization");
			/* BasicAuthenticationFilter */
			if (!StringUtils.isNotBlank(header) || !header.startsWith("Basic "))
				throw new AuthenticationException("请求头无信息！");
			String[] tokens = extractAndDecodeHeader(header, request);
			assert tokens.length == 2;
			/* BasicAuthenticationFilter */
			String clientId = tokens[0];
			String clientSecret = tokens[1];
			ClientDetails clientDetails = null;
			try {
				clientDetails = clientDetailsService.loadClientByClientId(clientId);
			} catch (NoSuchClientException e) {
				throw new AuthenticationException("clientId对应的配置信息不存在：" + clientId);
			}

			if (!StringUtils.equals(clientDetails.getClientSecret(), clientSecret))
				throw new AuthenticationException("clientSecret对应的配置信息不存在：" + clientSecret);

			TokenRequest tokenRequest = new TokenRequest(new HashMap<String, String>(), clientId,
					clientDetails.getScope(), "password");
			OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
			OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
			if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
				OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);				
				response.getWriter().write(objectMapper.writeValueAsString(new JsonResult<>(token)));
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.OK.value());
			response.getWriter().write(objectMapper.writeValueAsString(new JsonResult<>(e.getMessage())));		
		}
		if (!LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}

	/**
	 * Decodes the header into a username and password.
	 *
	 * @throws BadCredentialsException if the Basic header is not present or is not
	 *                                 valid Base64
	 */
	private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {

		byte[] base64Token = header.substring(6).getBytes("UTF-8");
		byte[] decoded;
		try {
			decoded = Base64.decode(base64Token);
		} catch (IllegalArgumentException e) {
			throw new BadCredentialsException("请求头信息解码失败！");
		}

		String token = new String(decoded, "UTF-8");

		int delim = token.indexOf(":");

		if (delim == -1) {
			throw new BadCredentialsException("无效的token");
		}
		return new String[] { token.substring(0, delim), token.substring(delim + 1) };
	}

}
