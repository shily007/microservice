package com.dy.shop.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dy.shop.api.entity.PayRecord;
import com.dy.shop.api.service.fallback.PayRecordServiceFallback;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@FeignClient(value = "MICROSERVICE-SHOP-ORDER", fallbackFactory = PayRecordServiceFallback.class)
@RequestMapping("payRecord")
public interface PayRecordService {

	@PostMapping
	void save(@RequestBody PayRecord payRecord);

}
