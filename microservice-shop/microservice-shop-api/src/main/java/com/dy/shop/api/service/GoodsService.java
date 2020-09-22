package com.dy.shop.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.shop.api.JsonResult;
import com.dy.shop.api.entity.Goods;
import com.dy.shop.api.service.fallback.GoodsServiceFallback;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@FeignClient(value = "MICROSERVICE-SHOP-GOODS", fallbackFactory = GoodsServiceFallback.class)
@RequestMapping(value = "goods")
@ResponseBody
public interface GoodsService {

	/**
	 * 根据id查询 getById
	 * 
	 * @param gid
	 * @return
	 * @author dy 2020年9月10日
	 */
	@GetMapping(value = "getById")
	JsonResult<Goods> getById(@RequestParam Long gid);

	/**
	 * 减库存 reduce
	 * 
	 * @param gid
	 * @param amount
	 * @return
	 * @author dy 2020年9月10日
	 */
	@PostMapping("reduce")
	JsonResult<String> reduce(@RequestParam Long gid, @RequestParam Integer amount);

	/**
	 * 加库存 increase
	 * 
	 * @param gid
	 * @param quantity
	 * @author dy 2020年9月10日
	 */
	@PostMapping("increase")
	void increase(@RequestParam Long gid, @RequestParam Integer quantity);

}
