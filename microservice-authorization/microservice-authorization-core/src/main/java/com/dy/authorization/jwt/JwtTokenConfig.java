package com.dy.authorization.jwt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.dy.authorization.properties.SecurityConstants;

/**
 * jwtToken相关配置
 * @author dy
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "com.dy.security.oauth2", name = "storeType", havingValue = "jwt", matchIfMissing = true)
public class JwtTokenConfig {
	
	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey(SecurityConstants.JWT_SIGNING_KEY);
		return accessTokenConverter;
	}
	
	@Bean
	@ConditionalOnMissingBean(name = "jwtTokenEnhancer")
	public TokenEnhancer jwtTokenEnhancer() {
		return new JwtTokenEnhancer();
	}

}
