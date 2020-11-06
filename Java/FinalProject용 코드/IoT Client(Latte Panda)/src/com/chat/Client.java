package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
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
			while(true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(address, port);
					break;
				} catch (Exception e1) {
					System.out.println("Retry ...");
				}
			}
		} 
		System.out.println("Connected Server: " + address);
		sender = new Sender(socket);
		new Receiver(socket).start();
	}

	public void sendTarget(String ip, String cmd) {
		ArrayList<String> ips = new ArrayList<String>();
		ips.add(ip);
		Msg msg = new Msg(id, cmd);
		sender.setMsg(msg);
		new Thread(sender).start();
	}

	
	// 메세지를 입력받는다.
	public void sendMsg(String ss) {
//		Scanner sc = new Scanner(System.in);
//		while(true){
//			System.out.println("Input msg");
//			String ms = sc.nextLine();
//			
//			// 1을 보내면 서버에서는 사용자 리스트를 보낸다.
//			Msg msg = null;
//			if(ms.equals("1")) {
//				msg = new Msg(id, ms);
//				
//			}else {
//				// 귓속말 하고자하는 상대의 ip 주소 지정
//				ArrayList<String> ips = new ArrayList<>();
//				ips.add("/172.30.1.27");
//				//msg = new Msg(ips,id,ms);
//				
//				// 모두에게 보낼 때
//				msg = new Msg(null,id,ms);
//			}
			
//			if(ms.equals("q")) {
//				break;
//			}
//		}
//		sc.close();
		Msg msg = new Msg(null,id,ss);
		sender.setMsg(msg);
		new Thread(sender).start();
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("bye ...");
	}

	
	// 메세지를 보낸다.
	class Sender implements Runnable {
		Socket socket;
		ObjectOutputStream oo;
		Msg msg;
		
		public Sender (Socket socket) throws IOException {
			this.socket = socket;
			oo = new ObjectOutputStream(socket.getOutputStream());
		}
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			if(oo != null) {
				try {
					oo.writeObject(msg);
				} catch (IOException e) {
					// 서버가 죽어 있을 때
					// 더 이상의 메세지가 날라가지 않을 때 에러가 난다.
					//e.printStackTrace();
					
					try {
						if(socket != null) {
							socket.close();
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
					
					try {
						// 다시 서버와 연결 시도 
						System.out.println("Retry ...");
						Thread.sleep(2000);
						connect();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} // end try
			}
		}
		
		
	}
	
	class Receiver extends Thread {
		ObjectInputStream oi;
		public Receiver(Socket socket) throws IOException {
			oi = new ObjectInputStream(socket.getInputStream());
		}
		@Override
		public void run() {
			while(oi != null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					if(msg.getMaps() != null) {
						HashMap<String, Msg> hm = msg.getMaps();
						Set<String> keys = hm.keySet();
						for(String k : keys) {
							System.out.println(k);
						}
						continue;
					}
					System.out.println(msg.getId() + msg.getMsg());
				} catch(Exception e) {
					//e.printStackTrace();
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

	public static void send() {
		HttpSender sender = null;
		while (true) {
			String urlstr = "http://192.168.0.17/tcpip/view/main.jsp";
			URL url = null;
			try {
				double temp = Math.random() * 20;
				url = new URL(urlstr + "?temp=" + temp);
				sender = new HttpSender(temp, url);
				new Thread(sender).start();
			} catch (Exception e) {
//				break;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class HttpSender implements Runnable {

		URL url = null;
		double temp;

		public HttpSender() {
		}

		public HttpSender(double temp, URL url) {
			this.temp = temp;
			this.url = url;
		}

		@Override
		public void run() {
			HttpURLConnection con = null;
			try {
				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(5000);
				con.setRequestMethod("POST");
				con.getInputStream();
				System.out.println("temp:" + temp);
			} catch (Exception e) {

			} finally {
				con.disconnect();
			}
		}

	}
	
//	public static void main(String[] args) {
//		Client client = new Client("192.168.0.17", 5555, "[Jeong]");
//		try {
//			client.connect();
//			client.sendMsg(null);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		//send();
//	}

}