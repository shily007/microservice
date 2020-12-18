package com.dy.auth.interceptor;

/**
 * 
 * 
 * @author dy
 * 2020年12月17日
 */
public interface AuthUserService {
	
	AuthUser loadByUsernamer(String username);

	AuthUser loadByOpenid(String openid, String loginType);

}
