package com.dy.shop.order.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.dy.kafka.domain.Message;
import com.dy.shop.api.ShopConstants;
import com.dy.shop.api.entity.Order;
import com.dy.shop.api.service.OrderService;

/**
 * 消息监听器
 * 
 * @author dy 2020年9月8日
 */
@Component
public class PaidListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderService orderService;

	@KafkaListener(topics = ShopConstants.ORDER_PAID, groupId = "shop")
	public void listen(Message message) {
		logger.info("消费的消息：" + message.toString());
		Order order = orderService.getByNum(message.getMessage());
		if (order != null && order.getState() == 0) {
			order.setState(1);
			orderService.updateById(order);
		}
	}

}
