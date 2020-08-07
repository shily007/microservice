package com.dy.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.consumer.controller.JsonResult;
import com.dy.consumer.fallbackFactory.SayHelloServiceBack;


@FeignClient(name = "MICROSERVICE-COMMON-PROVIDER",fallbackFactory = SayHelloServiceBack.class)
@RequestMapping("say")
public interface SayHelloService {
	
	@ResponseBody
	@GetMapping("sayHello")
	JsonResult<String> sayHello();

}
