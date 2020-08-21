package com.dy.authorization.properties;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Title Oauth2ClientProperties
 * @Description  
 * @author dy
 * @date 2019年12月5日
 */
@Data
@Accessors(chain = true)
public class Oauth2ClientProperties {
	
	private String clientId;
	private String clientSecret;
	private int accessTokenValiditySeconds = 1800;

}
