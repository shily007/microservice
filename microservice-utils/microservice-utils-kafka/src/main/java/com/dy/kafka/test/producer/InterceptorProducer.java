package com.dy.kafka.test.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class InterceptorProducer {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// 配置信息
		Properties properties = new Properties();
		// kafka 集群，broker-list
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.111:9092");
		// key value序列化器
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		// 添加拦截器
		List<String> interceptors = new ArrayList<>();
		interceptors.add("com.dy.kafka.interceptor.TimeInterceptor");
		interceptors.add("com.dy.kafka.interceptor.CountInterceptor");
		properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);

		// 创建生产者对象
		KafkaProducer producer = new KafkaProducer<String, String>(properties);
		// 发送消息
		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<String, String>("first", "dy", "dyy--" + i), (metadata, exception) -> {
				if (exception == null)
					System.out.println(metadata.toString());
				else
					exception.printStackTrace();
			});
		}
		// 关闭资源
		producer.close();
	}

}
