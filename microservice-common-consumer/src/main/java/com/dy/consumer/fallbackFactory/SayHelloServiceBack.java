package com.dy.consumer.fallbackFactory;

import org.springframework.stereotype.Component;

import com.dy.consumer.controller.JsonResult;
import com.dy.consumer.service.SayHelloService;

import feign.hystrix.FallbackFactory;

@Component
public class SayHelloServiceBack implements FallbackFactory<SayHelloService> {

	@Override
	public SayHelloService create(Throwable cause) {
		return new SayHelloService() {
			
			@Override
			public JsonResult<String> sayHello() {
				return new JsonResult<>(false,"error hello");
			}
		};
	}


}
