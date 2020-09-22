package com.dy.shop.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.kafka.domain.Message;
import com.dy.shop.api.JsonResult;
import com.dy.shop.api.ShopConstants;
import com.dy.shop.api.entity.Goods;
import com.dy.shop.api.entity.Order;
import com.dy.shop.api.service.GoodsService;
import com.dy.shop.api.service.OrderService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/shop/order")
public class OrderController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	/**
	 * 下单 placeOrder
	 * 
	 * @param gid    商品id
	 * @param amount 商品数量
	 * @return
	 * @author dy 2020年9月10日
	 */
	@PostMapping
	public JsonResult<String> placeOrder(Long gid, Integer amount) {
		JsonResult<Goods> result = goodsService.getById(gid);
		if (result == null) {
			return new JsonResult<>("商品不存在！");
		} else if (result.getData() != null && result.getData().getId() <= 0) {
			return new JsonResult<>(result.getData().getName());
		}
		if (result.getData().getAmount() < amount) {
			return new JsonResult<>("商品库存不足！");
		}
		JsonResult<String> result2 = goodsService.reduce(gid, amount);
		if (result2 == null || !result2.isSuccess()) {
			return result2;
		}
		Order order = new Order();
		order.setGid(gid);
		order.setQuantity(amount);
		DateFormat df = new SimpleDateFormat("yyMMddHHmmssSSS");
		String num = df.format(System.currentTimeMillis());
		order.setNum(num);
		order.setPrice(result.getData().getPrice());
		order.setSubtotal(result.getData().getPrice() * amount);
		order.setConsignee("dy");
		order.setAddr("成都市双流区");
		order.setPhone("19934524003");
		orderService.save(order);
		kafkaTemplate.send(ShopConstants.ORDER_PAID, new Message("placeOrder", num));
		kafkaTemplate.send(ShopConstants.ORDER_PAID, new Message("placeOrder", num));
		return new JsonResult<>(true, order.getNum());
	}

}
