package com.dy.kafka.test.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.common.TopicPartition;

public final class MyConsumer {
	
	String name;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int n = 20;
		dec(n);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(null, null);
		System.out.println("11111111111");
		Properties properties = new Properties();
		// 连接集群
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.111:9092");
		// 开启自动提交
//		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		// 自动提交延迟
		properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		// key value的反序列化的类
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");
		// 消费者组
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "ct");
		// 重置消费者的offset
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		// 创建消费者
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		// 订阅主题
		consumer.subscribe(Arrays.asList("ct"));
		// 解析并打印数据
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> consumerRecord : records) {
				System.out.println(consumerRecord.key() + "--" + consumerRecord.value());
			}
//			consumer.commitSync();
			consumer.commitAsync(new OffsetCommitCallback() {

				@Override
				public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
					if (exception != null)
						exception.printStackTrace();
				}
			});
		}
//		consumer.close();
	}
	
	public static void dec(int n) {
		int i = 2;
		while (n%i!=0) {
			i++;
		}
		System.out.print(i + "\t");
		if(i != n) {
			dec(n/i);
		}
		System.out.println();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		}, 0);
	}

}
