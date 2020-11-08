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
	
	// client���� �޼����� �޴´�.
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
		
		// ��Ʈ��ũ�� �����忡�� ���۽��Ѿ� �Ѵ�.
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = null;
						System.out.println("Ready Server ...");
						socket = serverSocket.accept();
						// ������ client���� ip address Ȯ��
						System.out.println(socket.getInetAddress());
						makeOut(socket);
						
						// client�� ���� ������ ���ο� �����尡 ����
						new Receiver(socket).start();
						
					} catch(Exception e) {
						e.printStackTrace();
					}
				} // end while
			}
		};
		
		new Thread(r).start();
		
			
	}
	
	// ������ client���� outputstream�� hashmap�� �����Ѵ�.
	public void makeOut(Socket socket) throws IOException {
		ObjectOutputStream oo;
		oo = new ObjectOutputStream(socket.getOutputStream());
		maps.put(socket.getInetAddress().toString(), oo);
		System.out.println("�����ڼ�: " + maps.size());
	}
	
	// client���� �޴´�.
	// sendMsg�� ȣ���Ͽ� �޼��� ��ü�� �޴´�.
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
						// ������ exception�� ���� client�� �����Ѵ�.
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
						// 1�� ���� client
						// ������ ������ ip��
						msg.setMaps(hm);
					}
					System.out.println(msg.getId() + msg.getMsg());
					sendMsg(msg);
				} catch (Exception e) { // client�� ���ڱ� ���� �ߴܵ� ���
					maps.remove(socket.getInetAddress().toString());
					System.out.println(socket.getInetAddress()+".. Exited");
					System.out.println("�����ڼ�: " + maps.size());
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
	
	// ��ü���� �޼����� �����ͼ� Sender�� ȣ���Ѵ�.
	public void sendMsg(Msg msg) {
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}
	
	// client�鿡�� �޼��� �����Ѵ�.
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
		
		// ���� ����
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}