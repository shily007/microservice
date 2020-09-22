package com.dy.shop.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dy.shop.api.entity.Order;
import com.dy.shop.api.service.fallback.OrderServiceFallback;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@FeignClient(value = "MICROSERVICE-SHOP-ORDER", fallbackFactory = OrderServiceFallback.class)
@RequestMapping("order")
public interface OrderService {

	/**
	 * 保存订单
	 * save
	 * @param order
	 * @author dy
	 * 2020年9月10日
	 */
	@PostMapping
	Long save(@RequestBody Order order);

	/**
	 * 根据订单编号查询订单
	 * getByNum
	 * @param num
	 * @return
	 * @author dy
	 * 2020年9月10日
	 */
	@GetMapping("getByNum")
	Order getByNum(@RequestParam String num);

	/**
	 * 根据id修改
	 * updateById
	 * @param order
	 * @author dy
	 * 2020年9月10日
	 */
	@PutMapping
	void updateById(@RequestBody Order order);

}
