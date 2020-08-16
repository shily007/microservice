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
 * @Title MyOncePerRequestFilter
 * @Description 自定义过滤器
 * @author dy
 * @date 2019年11月29日
 */
@Component("myOncePerRequestFilter")
public class MyOncePerRequestFilter extends OncePerRequestFilter {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {     
			if(isDecrypt(request)) {
				RequestWrapper requestWrapper = new RequestWrapper(request);
				requestWrapper.decrypt();
				filterChain.doFilter(requestWrapper, response);
			}else {
				filterChain.doFilter(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json;charset=UTF-8");
			try {
				response.getWriter().write(objectMapper.writeValueAsString(new JsonResult<Object>(e.getMessage())));
			} catch (IOException ie) {
				ie.printStackTrace();
			}
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
		for (int i = 0; i < SecurityConstants.NEED_DECRYPT_PARAMS.length; i++) {
			Map<String, String[]> parameterMap = request.getParameterMap();
        	if(parameterMap.containsKey(SecurityConstants.NEED_DECRYPT_PARAMS[i])) 
        		return true;
		} 
		return false;
	}
}
