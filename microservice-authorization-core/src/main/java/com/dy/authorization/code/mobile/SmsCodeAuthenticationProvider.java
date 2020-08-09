package com.dy.authorization.code.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.Data;

/**
 * 手机短信登录处理器
 * @author dy
 *
 */
@Data
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

	private UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationToken.getPrincipal().toString());
		if(userDetails == null)
			throw new InternalAuthenticationServiceException("无法获取用户信息！");
		SmsCodeAuthenticationToken token = new SmsCodeAuthenticationToken(userDetails, userDetails.getAuthorities());
		token.setDetails(authenticationToken.getDetails());
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
