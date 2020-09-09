package com.dy.kafka.test.producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyProducer {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 配置信息
		Properties properties = new Properties();
		// kafka 集群，broker-list
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.111:9092");
		// 应答级别
		properties.put(ProducerConfig.ACKS_CONFIG, "all");
		// 重试次数
		properties.put(ProducerConfig.RETRIES_CONFIG, 1);
		// 批次大小
		properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		// 等待时间
		properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		// RecordAccumulator 缓冲区大小
		properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		// key value序列化器
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");

		// 创建生产者对象
		KafkaProducer producer = new KafkaProducer<String, String>(properties);
		// 发送消息
		for (int i = 0; i < 1000000000; i++) {
			producer.send(new ProducerRecord<String, String>("first", "dyy", "dy--" + i));
		}
		// 关闭资源
		producer.close();
	}

}
