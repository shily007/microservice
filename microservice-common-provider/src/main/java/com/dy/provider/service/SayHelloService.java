package com.dy.provider.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.provider.config.JsonResult;


@RequestMapping("say")
public interface SayHelloService {
	
	@ResponseBody
	@GetMapping("sayHello")
	JsonResult<String> sayHello();

}
