package com.dy.shop.api.service.fallback;


import org.springframework.stereotype.Component;

import com.dy.shop.api.entity.PayRecord;
import com.dy.shop.api.service.PayRecordService;

import feign.hystrix.FallbackFactory;

@Component
public class PayRecordServiceFallback implements FallbackFactory<PayRecordService> {

	@Override
	public PayRecordService create(Throwable cause) {
		return new PayRecordService() {

			@Override
			public void save(PayRecord payRecord) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
