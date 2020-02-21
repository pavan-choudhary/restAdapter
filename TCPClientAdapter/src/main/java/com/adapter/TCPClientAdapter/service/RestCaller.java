package com.adapter.TCPClientAdapter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RestCaller {
	
//	@Autowired
//	private RestTemplate restClient;
	private static final Logger LOG = LogManager.getLogger(RestCaller.class);
	
	@HystrixCommand(fallbackMethod = "sendToRest_Fallback")
	public boolean sendToRest(String message, String url){
		LOG.info(url);
		RestTemplate restClient = new RestTemplate();
		String respone = restClient.postForObject(url, message, String.class);
		if(respone.equals("success"))
			return true;
		else
			return false;
		
	}
	
	   @SuppressWarnings("unused")
	    private boolean sendToRest_Fallback(String message, String url) {
	 
	        LOG.error("Fallback method called. Service not found. url: "+url+", message: "+message);
	 
	        return false;
	    }

}
