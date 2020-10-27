package com.tcpip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	int port;
	String ip;
	
	// socket�� ������ Ŭ���̾�Ʈ ���ʿ� ��� �ִ�.
	Socket socket;
	
	OutputStreamWriter ow;
	BufferedWriter bw;
	
	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void connectServer() {
		try {
			System.out.println("Start Client");
			
			// ������ ���� ������ �����Ϸ��� �� �� ������ ������ ������ ������ ������
			socket = new Socket(ip, port);
			
			System.out.println("Connected ...");
		}  catch (Exception e) {
			// ������ �������� ��
			while(true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(ip, port);
					System.out.println("Connected ...");
					break;
				} catch (Exception e1) {
					System.out.println("Re Try ...");
				}
			}
		}
	}
	
	public void close() throws IOException {
		if(socket != null) {
			socket.close();
		}
		if(bw != null) {
			bw.close();
		}
	}
	
	public void request(String msg) throws IOException {
		try {
			ow = new OutputStreamWriter(socket.getOutputStream());
			bw = new BufferedWriter(ow);
			bw.write(msg);
			//bw.flush();
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		Client client = null;
		client = new Client("192.168.0.7", 9999);
		client.connectServer();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input msg");
			String msg = sc.nextLine();
			if(msg.equals("q")) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			try {
				client.request(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("End Client");
	}


}
