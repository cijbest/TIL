package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.HashMap;


import com.msg.Msg;

public class Server {

	int port;
	
	// client들의 메세지를 받는다.
	HashMap<String, ObjectOutputStream> maps;
	
	ServerSocket serverSocket;
	
	
	public Server() {}
	
	public Server(int port) {
		this.port = port;
		maps = new HashMap<>();
	}
	
	public void startServer() throws Exception {
		serverSocket = new ServerSocket(port);
		System.out.println("Strat Server ...");
		
		// 네트워크는 스레드에서 동작시켜야 한다.
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = null;
						System.out.println("Ready Server ...");
						socket = serverSocket.accept();
						// 접속한 client들의 ip address 확인
						System.out.println(socket.getInetAddress());
						makeOut(socket);
						
						// client가 들어올 때마다 새로운 스레드가 생성
						new Receiver(socket).start();
						
					} catch(Exception e) {
						e.printStackTrace();
					}
				} // end while
			}
		};
		
		new Thread(r).start();
		
			
	}
	
	// 각각의 client들의 outputstream을 hashmap에 저장한다.
	public void makeOut(Socket socket) throws IOException {
		ObjectOutputStream oo;
		oo = new ObjectOutputStream(socket.getOutputStream());
		maps.put(socket.getInetAddress().toString(), oo);
		System.out.println("접속자수: " + maps.size());
	}
	
	// client들을 받는다.
	// sendMsg를 호출하여 메세지 객체를 받는다.
	class Receiver extends Thread {
		Socket socket;
		ObjectInputStream oi;
		
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			oi = new ObjectInputStream(this.socket.getInputStream());
		}

		@Override
		public void run() {
			while(oi != null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					if(msg.getMsg().equals("q")) {
						// 강제로 exception을 내서 client를 삭제한다.
						throw new Exception();
					}else if(msg.getMsg().equals("1")) {
						String ip = socket.getInetAddress().toString();
						ArrayList<String> ips = new ArrayList<>();
						ips.add(ip);
						msg.setIps(ips);
						
						Set<String> keys = maps.keySet();
						HashMap<String, Msg> hm = new HashMap<>();
						for(String k : keys) {
							hm.put(k, null);
						}
						// 1을 보낸 client
						// 서버의 접속자 ip들
						msg.setMaps(hm);
					}
					System.out.println(msg.getId() + msg.getMsg());
					sendMsg(msg);
				} catch (Exception e) { // client가 갑자기 접속 중단된 경우
					maps.remove(socket.getInetAddress().toString());
					System.out.println(socket.getInetAddress()+".. Exited");
					System.out.println("접속자수: " + maps.size());
					break;
				} 
			} // end while
			
			try {
				if(oi != null) {
					oi.close();
				}
				if(socket != null) {
					socket.close();
				}
			} catch(Exception e) {
				
			}
		}
		
	}
	
	// 객체에서 메세지로 가져와서 Sender를 호출한다.
	public void sendMsg(Msg msg) {
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}
	
	// client들에게 메세지 전송한다.
	class Sender extends Thread {
		Msg msg;
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		
		@Override
		public void run() {
			Collection<ObjectOutputStream> cols = maps.values();
			Iterator<ObjectOutputStream> it = cols.iterator();
			while(it.hasNext()) {
				try {
					
					if(msg.getIps() != null) {
						for(String ip: msg.getIps()) {
							maps.get(ip).writeObject(msg);
						}
						break;
					}
					
					it.next().writeObject(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	

	public static void main(String[] args) {
		Server server = new Server(5555);
		
		// 서버 실행
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}