package com.dy.authorization.browser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.dy.api.utils.JsonResult;
import com.dy.authorization.properties.SecurityConstants;
import com.dy.authorization.rsa.RSAUtil;

@Controller
public class BrowserController {

	@Autowired
	private RestTemplate restTemplate;

	private static final String AUTHORIZATION_URL_PREFIX = "http://MICROSERVICE-AUTHORIZATION-SERVER";

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/login")
	public String add(String username, String password, HttpServletRequest request) {
		String encrypt = RSAUtil.encrypt(password, SecurityConstants.PUBLIC_KEY);
		JsonResult<String> result = restTemplate.postForObject(
				AUTHORIZATION_URL_PREFIX + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, null, JsonResult.class,
				username, encrypt);
		if(result.isSuccess()) {
			HttpSession session = request.getSession();
			session.setAttribute("access_token", result.getData());	
			return "redirect:/";
		}else {
			return "redirect:/login?error";
		}
	}

}
