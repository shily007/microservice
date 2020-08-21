package com.dy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.api.service.SayHelloService;
import com.dy.api.utils.JsonResult;

@RestController
public class SayHelloController {

	@Autowired
	private SayHelloService sayHelloService;
	
	@GetMapping("sayHello")
	public JsonResult<String> sayHello() {
		JsonResult<String> result = sayHelloService.sayHello();
		result.setData("microservice-common-consumer");
		return result;
	}
	
}
