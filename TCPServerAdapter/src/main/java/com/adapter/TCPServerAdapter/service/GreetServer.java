package com.adapter.TCPServerAdapter.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
	 private ServerSocket serverSocket;
	    private Socket clientSocket;
	    public static PrintWriter out;
	    public static BufferedReader in;
	 
	    public void start(int port) {
	    	try{
	        serverSocket = new ServerSocket(port);
	        while(true){
	        clientSocket = serverSocket.accept();
	        out = new PrintWriter(clientSocket.getOutputStream(), true);
	        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        String greeting = in.readLine();
	            if ("001001000200.1.94.152  12345678901234567890123456789012345678900".equals(greeting)) {
	                out.println("00000200000");
	               
	                int i =0;
	                while (i<5) {
						Thread.sleep(20000);
						System.out.println("data commming");
						out.println("0610190072020-02-14:10:00:35.354022N00007B252020-02-14:10:00:31.0000590000000059C007STFIC0928042120200214000000000700000000000000000099.0200000007000000000.00COL17CT031850000000000FS  COP00000001.0000+0000000000.0000NP00.0000NTES-CUP     DCV+0000000000.0000S000 NO   O      099.02020200214QASPT00438202104282012042803287+0000000000.0000   E C +0000000000.00000000000000000000000000000000.00000000000000.00DE             +0000000000.0000    00100100300000000005310:00                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ]");
						if(i == 2 )
							out.println("06660190000000");
						i++;
					}
	                out.println("566565");
	            }
	            if("KEEP ALIVE".equals(greeting)){
	            	out.println("00000500000");
	            }
	            else {
	                out.println("unrecognised greeting");
	            }
	        }
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	    }
	 
	    public void stop() {
	    	try{
	        in.close();
	        out.close();
	        clientSocket.close();
	        serverSocket.close();
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    public static void main(String[] args) {
	        GreetServer server=new GreetServer();
	        server.start(6666);
}

}
