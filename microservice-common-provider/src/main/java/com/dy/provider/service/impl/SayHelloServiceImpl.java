package com.dy.provider.service.impl;

import org.springframework.stereotype.Service;

import com.dy.provider.config.JsonResult;
import com.dy.provider.service.SayHelloService;

@Service
public class SayHelloServiceImpl implements SayHelloService {

	@Override
	public JsonResult<String> sayHello() {
		return new JsonResult<>(true,"hello word");
	}

}
