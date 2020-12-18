package com.dy.auth.interceptor;

import org.springframework.stereotype.Component;

@Component
public class DefautAuthUserService implements AuthUserService {

	@Override
	public AuthUser loadByUsernamer(String username) {
		return new AuthUser(username, "82688b7a96168e7ca7b6ae7a9f5e3a09sTTrd8WKYht9iUjpuFpe0wnPrN2ZiDbN");
	}

	@Override
	public AuthUser loadByOpenid(String openid, String loginType) {
		// TODO Auto-generated method stub
		return null;
	}

}
