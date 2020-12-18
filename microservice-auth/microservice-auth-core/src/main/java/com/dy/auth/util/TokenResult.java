package com.dy.auth.util;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TokenResult {
	
	private String access_token;
	private String token_type = "bearer";
	private String refresh_token;
	private int expires_in;

}
