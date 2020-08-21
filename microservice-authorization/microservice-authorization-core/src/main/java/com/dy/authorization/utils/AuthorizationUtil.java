package com.dy.authorization.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 工具类
 * 
 * @author dy
 * 2020年8月11日
 */
public class AuthorizationUtil {
	
	/**
	 * 判断登录方式是否是json isJSONLogin
	 * 
	 * @param request
	 * @return
	 * @author dy 2020年8月11日
	 */
	public static boolean isJSONLogin(HttpServletRequest request) {
		String[] parameter = getParameter(request, "loginType");
		if (parameter != null && parameter.length > 0 && parameter[0].equals("JSON")) {
			return true;
		}
		return false;
	}

	/**
	 * 根据参数名获取参数值 getParameter
	 * 
	 * @param request
	 * @param parameterName
	 * @return String[]
	 * @author dy 2020年8月11日
	 */
	public static String[] getParameter(HttpServletRequest request, String parameterName) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String[] parameter = parameterMap.get(parameterName);
		if (parameter == null || parameter.length == 0) {
			return null;
		}
		return parameter;
	}

}
