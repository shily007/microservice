package com.dy.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.dy.kafka.domain.Message;

/**
 * 消息监听器
 * 
 * @author dy 2020年9月8日
 */
@Component
public class MsgListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaListener(topics = "test", groupId = "test-consumer")
	public void listen(Message message) {
		logger.info("消费的消息：" + message.toString());
	}

}
