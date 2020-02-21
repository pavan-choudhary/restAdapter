package com.adapter.restadapter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.adapter.restadapter.model.DataObject;
import com.adapter.restadapter.model.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;

@RefreshScope
@Service
public class KafkaProducer {

	private static final Logger LOG = LogManager.getLogger(KafkaProducer.class);

	@Value(value = "${kafka.topicName}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void produceJsonData(Payload payload) throws Exception {
		ObjectMapper obj = new ObjectMapper();
		LOG.info(">>Data to kafka topic " + obj.writeValueAsString(payload));
		sendMessage(obj.writeValueAsString(payload));
		LOG.info("<<Data sent to topic " + topicName);
	}

	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName, msg);
	}

}
