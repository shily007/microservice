package com.dy.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.kafka.domain.Message;
import com.dy.shop.api.entity.PayRecord;
import com.dy.shop.api.service.PayRecordService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/shop/payRecord")
public class PayRecordController {

	@Autowired
	private PayRecordService payRecordService;
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	/**
	 * 支付回调接口 name
	 * 
	 * @param num    订单编号
	 * @param amount 支付金额
	 * @author dy 2020年9月10日
	 */
	@GetMapping
	public void payReto(String num, Integer amount) {
		PayRecord payRecord = new PayRecord();
		payRecord.setAmount(amount);
		payRecord.setNum(num);
		payRecordService.save(payRecord);
		kafkaTemplate.send("orderPaid",new Message("payReto", num));
	}

}
