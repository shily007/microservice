package com.dy.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dy.kafka.domain.Message;

/**
 * 
 * 
 * @author dy 2020年9月8日
 */
@RestController
public class SendMessageController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@GetMapping("send/{message}")
	public void sendMessage(@PathVariable String message) {
		logger.info("发送的消息：" + message);
		this.kafkaTemplate.send("test", new Message("test", message));
	}
}
