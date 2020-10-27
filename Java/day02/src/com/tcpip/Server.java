package com.tcpip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	int port = 9999;
	
	ServerSocket serverSocket;
	Socket socket;
	
	InputStreamReader ir;
	BufferedReader br;
	
	public Server() {
		
	}
	
	public void startServer() throws IOException {
		
		serverSocket = new ServerSocket(port);
		try {
			while(true) {
				System.out.println("Ready Server ...");
				socket = serverSocket.accept();
				System.out.println("Connected ...");
				
				// exception이 날 수 있는 구간
				ir = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(ir);
				String msg = "";
				msg = br.readLine();
				System.out.println(msg);
			}
		} catch(Exception e) {
			throw e;
		} finally {
			if(br != null) {
				br.close();
			}
			if(socket != null) {
				socket.close();
			}
		}
	}
	
	public static void main(String[] args) {
		Server server = null;
		server = new Server();
		try {
			server.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("End Server");
		
	}

}
