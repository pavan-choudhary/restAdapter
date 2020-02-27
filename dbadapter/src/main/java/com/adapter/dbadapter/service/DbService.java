package com.adapter.dbadapter.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.adapter.dbadapter.repo.Dao;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class DbService {
	
	@Autowired
	private Dao dao;
	
	@Autowired
	private KafkaProducer producer;
	
	private static final Logger LOG = LogManager.getLogger(DbService.class); 
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Scheduled(cron = "${cron.expression}")
//	@Scheduled(fixedDelay = 5000)
	public void job() throws JsonProcessingException {
		Date date = new Date();
		LOG.info("Scheduler started at: " + dateFormat.format(date));
		
		for(String s : dao.getAll()) {			
			try {
				producer.produceJsonData(s);
			} catch (Exception e) {
				LOG.error("Cannot send data:"+ s +", Message: "+e.getMessage());
			}
		}
	}
}
