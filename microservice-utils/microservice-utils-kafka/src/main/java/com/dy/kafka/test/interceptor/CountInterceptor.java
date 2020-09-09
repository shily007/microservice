package com.dy.kafka.test.interceptor;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class CountInterceptor implements ProducerInterceptor<String, String> {

	private int success = 0;
	private int error = 0;

	@Override
	public void configure(Map<String, ?> configs) {

	}

	@Override
	public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
		return record;
	}

	@Override
	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
		if (metadata != null)
			success++;
		else
			error++;
	}

	@Override
	public void close() {
		System.out.println("success:" + success);
		System.out.println("error:" + error);
	}

}
