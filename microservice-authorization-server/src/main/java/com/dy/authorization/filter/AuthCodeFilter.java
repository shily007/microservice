package com.dy.authorization.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dy.api.utils.JsonResult;
import com.dy.authorization.properties.SecurityConstants;
import com.dy.authorization.wrapper.RequestWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 验证码过滤器
 * 
 * @author dy
 *
 */
@Component("authCodeFilter")
public class AuthCodeFilter extends OncePerRequestFilter {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (isDecrypt(request)) {
			try {
				RequestWrapper requestWrapper = new RequestWrapper(request);
				requestWrapper.decrypt();
				filterChain.doFilter(requestWrapper, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				response.setContentType("application/json;charset=UTF-8");
				try {
					response.getWriter().write(objectMapper.writeValueAsString(new JsonResult<>(e.getMessage())));
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * @Description 判断是否需要解密操作
	 * @param request
	 * @return
	 * @author dy
	 * @date 2019年12月13日
	 */
	private boolean isDecrypt(HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (parameterMap != null && parameterMap.size() > 0) {
			for (int i = 0; i < SecurityConstants.NEED_DECRYPT_PARAMS.length; i++) {
				if (parameterMap.containsKey(SecurityConstants.NEED_DECRYPT_PARAMS[i]))
					return true;
			}
		}
		return false;
	}

}
