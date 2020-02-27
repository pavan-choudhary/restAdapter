package com.adapter.dbadapter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class KafkaProducer {

	private static final Logger LOG = LogManager.getLogger(KafkaProducer.class);

	@Value(value = "${kafka.topicName}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void produceJsonData(String payload) throws Exception {
		LOG.info(">>Data to kafka topic " + payload);
		sendMessage(payload);
		LOG.info("<<Data sent to topic " + topicName);
	}

	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName, msg);
	}

}
