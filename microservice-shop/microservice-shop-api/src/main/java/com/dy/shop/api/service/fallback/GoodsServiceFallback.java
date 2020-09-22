package com.dy.shop.api.service.fallback;


import org.springframework.stereotype.Component;

import com.dy.shop.api.JsonResult;
import com.dy.shop.api.entity.Goods;
import com.dy.shop.api.service.GoodsService;

import feign.hystrix.FallbackFactory;

@Component
public class GoodsServiceFallback implements FallbackFactory<GoodsService> {

	@Override
	public GoodsService create(Throwable cause) {
		cause.printStackTrace();
		return new GoodsService() {

			@Override
			public JsonResult<Goods> getById(Long gid) {
				return new JsonResult<Goods>(new Goods().setId((long) -1).setName("商品不存在！"));
			}

			@Override
			public JsonResult<String> reduce(Long gid, Integer amount) {
				return new JsonResult<>("操作失败！");
			}

			@Override
			public void increase(Long gid, Integer quantity) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
