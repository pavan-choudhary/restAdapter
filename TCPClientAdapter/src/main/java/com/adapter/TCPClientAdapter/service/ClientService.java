package com.adapter.TCPClientAdapter.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class ClientService {
	
	private Socket clientSocket;
	private static PrintWriter out;
	private static BufferedReader in;
	private static final Logger LOG = LogManager.getLogger(ClientService.class);
	
	@Value(value = "${adapter.server.ip}")
	private String serverIp;
	
	@Value(value = "${adapter.server.port}")
	private int serverPort;
	
	@Value(value = "${stream.connection.message}")
	private String connectionMessage;
	
	@Value(value = "${stream.connection.response}")
	private String connectionResponse;
	
	@Value(value = "${stream.heartbeat.response}")
	private String heartBeat;
	
	@Value(value = "${connection.retry.time}")
	private static long retryTime;
	
	@Value(value = "${stream.key}")
	private String key;
	
	@Value(value = "${stream.value}")
	private String value;

	@Autowired
	private RestCaller restCaller;
	
	public void maintainConnection() throws Exception {
		String response = null;
		response = establishConnection();
		boolean serviceStatus = checkServiceStatus(response);
		while (serviceStatus) {
			serviceStatus = sendStreamToRest();
		}

	}
	
	public Map<String, String> mapping(){
		Map<String, String> maps = new HashMap<String, String>();
		String[] keys = this.key.split(",");
		String[] value = this.value.split(",");
		
		for(int i =0; i<keys.length;i++){
			maps.put(keys[i],value[i]);
		}
		return maps;
	}

	public boolean sendStreamToRest() throws Exception {
		boolean status = true;
		Map<String, String> maps = this.mapping();
		String resp = in.readLine();
		LOG.info("message received from server "+resp);
		
		if (resp.equals(heartBeat)) {
			LOG.info("heartbeat received");
		}
		if (maps.get(resp.substring(0, 6)) != null) {
			boolean restStatus = restCaller.sendToRest(resp, maps.get(resp.subSequence(0, 6)));
			if(!restStatus){
				LOG.error(this.getClass().getName(), "error accoured in contacting the rest service ");
			}
		} else {
			stopConnection();
			status = false;
		}
		return status;

	}

	public boolean checkServiceStatus(String response) throws Exception {
		LOG.info("checking connection");
		boolean serviceUp = false;
		if (response.equals(connectionResponse)) {
			LOG.info("connection up");
			serviceUp = true;
		} else {
			while (!serviceUp) {
				Thread.sleep(retryTime * 1000);
				response = establishConnection();
				if (response.equals(connectionResponse))
					serviceUp = true;
			}
		}
		return serviceUp;
	}

	public String establishConnection() throws Exception {
		startConnection();
		LOG.info("connection message send");
		String response = sendMessage(connectionMessage);
		LOG.info("response received "+response);
		return response;
	}

	public String sendMessage(String msg) throws Exception {
		out.println(msg);
		String resp = in.readLine();
		return resp;
	}

	public void startConnection() throws Exception {
		LOG.info("initalising connection");
		clientSocket = new Socket(serverIp, serverPort);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		LOG.info("connection request send");
	}

	public void stopConnection() throws Exception {
		in.close();
		out.close();
		clientSocket.close();
	}

}
