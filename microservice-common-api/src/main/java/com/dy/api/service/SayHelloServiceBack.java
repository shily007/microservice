package com.dy.api.service;

import com.dy.api.utils.JsonResult;
import org.springframework.stereotype.Component;


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
