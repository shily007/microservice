package com.dy.shop.api.service.fallback;


import org.springframework.stereotype.Component;

import com.dy.shop.api.entity.Order;
import com.dy.shop.api.service.OrderService;

import feign.hystrix.FallbackFactory;

@Component
public class OrderServiceFallback implements FallbackFactory<OrderService> {

	@Override
	public OrderService create(Throwable cause) {
		return new OrderService() {

			@Override
			public Long save(Order order) {
				return null;
			}

			@Override
			public Order getByNum(String num) {
				return null;
			}

			@Override
			public void updateById(Order order) {
			}
			
		};
	}

}
