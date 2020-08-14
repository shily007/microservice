package com.dy.authorization.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Title ActionFilter
 * @Description 权限过滤器
 * @author dy
 * @date 2019年11月29日
 */
@Component("actionFilter")
public class ActionFilter extends OncePerRequestFilter {

	@Autowired
	PasswordEncoder encoder;
	private final String[] swaggerurls = { ".css", ".js", "swagger", "webjars", "v2", ".html", "publicKey", "file",
			"show" };

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!isSwagger(request.getRequestURI())) {
			checkAuthority(request, response, filterChain);
		}
//		try {
//			
//			HttpSession session = request.getSession();
//			Object obj = session.getAttribute("access_token");
//			if (obj != null) {
//				RequestWrapper requestWrapper = new RequestWrapper(request);
//				requestWrapper.addParameter("access_token", new String[] { "" + obj });
//				filterChain.doFilter(requestWrapper, response);
//				return;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		filterChain.doFilter(request, response);
	}

	/**
	 * 检查权限
	 * 
	 * @param request
	 * @param response
	 * @param filterChain
	 */
	protected void checkAuthority(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

	}

	/**
	 * @Description 检查是否是swaggerurl
	 * @param uri
	 * @return
	 * @author dy
	 * @date 2019年12月12日
	 */
	private boolean isSwagger(String uri) {
		for (int i = 0; i < swaggerurls.length; i++) {
			if (uri.contains(swaggerurls[i]))
				return true;
		}
		return false;
	}

}
