package com.dy.auth.interceptor;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * 
 * @author dy
 * 2020年12月17日
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class AuthUser {
	
	private String username;
	private String password;
	private Collection<String> authorities;	
	private Boolean expired = false;
	private Boolean locked = false;
	private Boolean enabled = true;
	
	/**
	 * Indicates whether the user's account has expired. An expired account cannot be
	 * authenticated.
	 *
	 * @return <code>true</code> if the user's account is valid (ie non-expired),
	 * <code>false</code> if no longer valid (ie expired)
	 */
	public boolean isAccountNonExpired() {
		return expired;
	}

	/**
	 * Indicates whether the user is locked or unlocked. A locked user cannot be
	 * authenticated.
	 *
	 * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
	 */
	public boolean isAccountNonLocked() {
		return locked;
	}

	/**
	 * Indicates whether the user is enabled or disabled. A disabled user cannot be
	 * authenticated.
	 *
	 * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
	 */
	public boolean isEnabled() {
		return enabled;
	}

	public AuthUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
