package com.dy.authorization.wrapper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dy.authorization.properties.SecurityConstants;
import com.dy.authorization.rsa.RSAUtil;

/**
 * @Title RequestWrapper
 * @Description 自定义HttpServletRequestWrapper
 * @author dy
 * @date 2019年12月13日
 */
public class RequestWrapper extends HttpServletRequestWrapper {

	private Logger logger = LoggerFactory.getLogger(Object.class);

	private Map<String, String[]> paramsMap = new HashMap<String, String[]>();// 将request对象中的参数修改后，放在这个集合里，随后项目取的所有Parameter都是从这个集合中取数

	/**
	 * 定义构造函数
	 * 
	 * @param request
	 */
	public RequestWrapper(HttpServletRequest request) {
		super(request);
		Map<String, String[]> params = (Map<String, String[]>) request.getParameterMap();
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			paramsMap.put(key, values);
		}
	}

	/**
	 * 解密 decrypt
	 * 
	 * @author dy 2020年8月12日
	 */
	public void decrypt() {
		for (int i = 0; i < SecurityConstants.NEED_DECRYPT_PARAMS.length; i++) {
			String[] values = paramsMap.get(SecurityConstants.NEED_DECRYPT_PARAMS[i]);
			if (values != null && values.length > 0) {
				if (values[0].contains(" "))// 使用postman可能会把+转为空格
					values[0] = values[0].replace(" ", "+");
				logger.info("解密前：" + values[0]);
				values[0] = RSAUtil.decrypt(values[0], SecurityConstants.PRIVATE_KEY);
				logger.info("解密后：" + values[0]);
			}
			paramsMap.put(SecurityConstants.NEED_DECRYPT_PARAMS[i], values);
		}
	}

	/**
	 * 添加元素 addParameter
	 * 
	 * @param key
	 * @param values
	 * @author dy 2020年8月12日
	 */
	public void addParameter(String key, String[] values) {
		paramsMap.put(key, values);
	}

	@Override
	public String getParameter(String name) {
		String[] values = paramsMap.get(name);
		if (values == null || values.length == 0) {
			return null;
		}
		return values[0];
	}

	@Override
	public Enumeration<String> getParameterNames() {
		Vector<String> v = new Vector<String>();
		for (String key : paramsMap.keySet()) {
			v.add(key);
		}
		return v.elements();
	}

	@Override
	public String[] getParameterValues(String name) {
		return paramsMap.get(name);
	}
}
