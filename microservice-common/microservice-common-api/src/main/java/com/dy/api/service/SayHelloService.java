package com.dy.api.service;

import com.dy.api.utils.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@FeignClient(name = "MICROSERVICE-COMMON-PROVIDER",fallbackFactory = SayHelloServiceBack.class)
@RequestMapping("say")
public interface SayHelloService {
	
	@ResponseBody
	@GetMapping("sayHello")
	JsonResult<String> sayHello();

}
