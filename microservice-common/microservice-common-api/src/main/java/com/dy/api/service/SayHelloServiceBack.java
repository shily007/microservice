package com.dy.api.service;

import org.springframework.stereotype.Component;

import com.dy.api.base.CommonErrorMsg;
import com.dy.api.utils.JsonResult;

import feign.hystrix.FallbackFactory;

@Component
public class SayHelloServiceBack implements FallbackFactory<SayHelloService> {

	@Override
	public SayHelloService create(Throwable cause) {
		return new SayHelloService() {
			
			@Override
			public JsonResult<String> sayHello() {
				return new JsonResult<>(CommonErrorMsg.SERVICE_CALL_FAILED);
			}
		};
	}


}
