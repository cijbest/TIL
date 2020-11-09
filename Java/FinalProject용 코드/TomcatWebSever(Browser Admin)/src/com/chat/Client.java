package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.msg.Msg;

public class Client {

	int port;
	String address;
	String id;

	Socket socket;
	Sender sender;

	public Client() {
	}

	public Client(String address, int port, String id) {
		this.address = address;
		this.port = port;
		this.id = id;
	}


	public void connect() throws IOException {
		try {
			socket = new Socket(address, port);
		} catch (Exception e) {
			while (true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(address, port);
					break;
				} catch (Exception e1) {
					System.out.println("Retry ...");
				}
			}
		}
		System.out.println("Connected Server:" + address);
		
		sender = new Sender(socket);
		

//		new Receiver(socket).start();

	}

	public void sendTarget(String ip, String cmd) {
		ArrayList<String> ips = new ArrayList<String>();
		ips.add(ip);
		Msg msg = new Msg(ips,id,cmd);
		sender.setMsg(msg);
		new Thread(sender).start();
	}
	
	
	public void sendMsg() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input msg");
			String ms = sc.nextLine();
			
			Msg msg = null;
			if(ms.equals("1")) {
				msg = new Msg(id,ms);
			}else {			
				ArrayList<String> ips = new ArrayList<>();
				ips.add("/172.30.1.16");
				msg = new Msg(ips,id,ms);
			}				
			sender.setMsg(msg);				
			new Thread(sender).start();		
			if (ms.equals("q")) {
				break;
			}
		}
		sc.close();
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("BYE ...");
	}

	class Sender implements Runnable {
		Socket socket;
		ObjectOutputStream oo;
		Msg msg;

		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			oo = new ObjectOutputStream(socket.getOutputStream());
		}

		public void setMsg(Msg msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			if (oo != null) {
				try {
					oo.writeObject(msg);
				} catch (IOException e) {
//					e.printStackTrace();
					try {
						if (socket != null) {
							socket.close();
						}
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					try {
						Thread.sleep(2000);
						connect();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}

	}

	// server���� ������ �޽����� �޴� ����
	class Receiver extends Thread {
		ObjectInputStream oi;
		public Receiver(Socket socket) throws IOException {
			oi = new ObjectInputStream(socket.getInputStream());
		}
		@Override
		public void run() {
			while(oi != null) {
				Msg msg  = null;
				try {
					msg = (Msg) oi.readObject();
					if(msg.getMaps() != null) {
						HashMap<String,Msg> hm = msg.getMaps();
						Set<String> keys = hm.keySet();
						for(String k : keys) {
							System.out.println(k);
						}
						continue;
					}
					System.out.println(msg.getId()+msg.getMsg());
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
			try {
				if(oi != null) {
					oi.close();
				}
				if(socket != null) {
					socket.close();
				}
			}catch(Exception e) {
				
			}
		}
		
	}

	public static void main(String[] args) {
		Client client = new Client("172.30.1.16", 5555, "[Jeong]");
		try {
			client.connect();
			client.sendMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}