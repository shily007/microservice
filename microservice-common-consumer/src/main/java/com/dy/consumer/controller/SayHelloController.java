package com.dy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.consumer.service.SayHelloService;

@RestController
public class SayHelloController {

	@Autowired
	private SayHelloService sayHelloService;
	
	@GetMapping("sayHello")
	public JsonResult<String> sayHello() {
		return sayHelloService.sayHello();
	}
	
}
