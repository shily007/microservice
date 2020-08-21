package com.dy.consumer.config;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 把request里的请求参数包括请求头全部复制到feign的request里
 * 
 * @author dy
 *
 */
@Configuration
public class FeginInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate requestTemplate) {
		try {
			checkClassRequestTemplate(requestTemplate);
			Map<String, String> headers = getHeaders();
			for (String headerName : headers.keySet()) {
				if (headerName.equals("content-length")) {
					continue;
				}
				requestTemplate.header(headerName, headers.get(headerName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解决@FeignClient注释下的类上的@RequestMapping("adminLog")中的path不起作用
	 * checkClassRequestTemplate
	 * 
	 * @param requestTemplate
	 * @author dy 2020年7月13日
	 */
	private void checkClassRequestTemplate(RequestTemplate requestTemplate) {
		Request data = requestTemplate.request();
		if (data == null)
			return;
//		Class<?> targetType = data.targetType();
//		if (targetType == null) {
//			return;
//		}
//		if (targetType.getInterfaces().length == 0) {// 没有有父接口直接返回
//			return;
//		}
//		RequestMapping requestMapping = targetType.getAnnotation(RequestMapping.class);
//		if (requestMapping == null) {
//			return;
//		}
//		String[] values = requestMapping.value();
//		String url = requestTemplate.url();
//		if (values[0].endsWith("/")) {
//			if (url.startsWith("/")) {
//				requestTemplate.uri(values[0] + url.substring(1));
//			} else {
//				requestTemplate.uri(values[0] + url);
//			}
//		} else {
//			if (url.startsWith("/")) {
//				requestTemplate.uri(values[0] + url);
//			} else {
//				requestTemplate.uri(values[0] + "/" + url);
//			}
//		}
	}

	private Map<String, String> getHeaders() {
		Map<String, String> map = new LinkedHashMap<>();
		try {
			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			if(ra != null) {
				HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
				Enumeration<String> enumeration = request.getHeaderNames();
				while (enumeration.hasMoreElements()) {
					String key = enumeration.nextElement();
					String value = request.getHeader(key);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}