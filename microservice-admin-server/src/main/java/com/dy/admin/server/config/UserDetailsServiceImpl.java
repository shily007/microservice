package com.dy.admin.server.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 
 * @author dy
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private Logger logger;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("登录用户：" + username);
		return new User(username, "$2a$10$27Q1VsnsYnw44RBHDLJXWu0d62FEOUBq19MkvNj/rxqAzqZnvGM2C", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	}

}
