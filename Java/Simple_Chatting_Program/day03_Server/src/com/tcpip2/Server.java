package com.tcpip2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.msg.Msg;

// Object Serialization ...

public class Server {
	
	int port;
	ServerSocket serverSocket;
	Socket socket;
	
	
	public Server() {}
	public Server(int port) {
		this.port = port;
	}
	class Receiver extends Thread{
		ObjectInputStream dis;
		Socket socket = null;
		public Receiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while(dis != null) {
				Msg mo = null;
				try {
					// 한글 받기가 원활하다
					mo = (Msg) dis.readObject();
					
					if(mo.getMsg().equals("q")) {
						System.out.println(mo.getId() + "님이 나갔습니다.");
						break;
					}
					System.out.println("[" + mo.getId() + "]" + mo.getMsg());
					
				} catch (Exception e) {
//					if(mo.getId() != null) {
//						System.out.println("[" + mo.getId() + "]" + mo.getMsg());
//					}
					break;
				} 
			}
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public void startServer() throws Exception {
		System.out.println("TCP/IP Server Start....");
		try {
			// Exception도 던지고 try catch도 한다. Exception 처리가 필요하므로
			serverSocket = new ServerSocket(port);
			
			while(true) {
				System.out.println("Ready Server ..");
				socket = serverSocket.accept();
				System.out.println("Connected..");
				
				// socket은 생성할 때마다 만들어 진다.
				new Receiver(socket).start();
			}
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	public static void main(String[] args) {
		Server server = new Server(7777);
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
