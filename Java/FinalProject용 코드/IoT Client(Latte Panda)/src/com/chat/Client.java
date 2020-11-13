package com.chat;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.msg.Msg;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;

public class Client {

	int port;
	String address;
	String id;
	Socket socket;
	Sender sender;
	
	// Serial ��ſ� �ʿ��� ���� �߰� 
	private BufferedInputStream bin;

	private InputStream in;

	private OutputStream out;

	private SerialPort serialPort;

	private CommPortIdentifier portIdentifier;

	private CommPort commPort;

	
	

	public Client() throws Exception {
		


	}
	public void connectSerial() throws Exception {

		 

		if (portIdentifier.isCurrentlyOwned()) {

			System.out.println("Error: Port is currently in use");

		} else {

			commPort = portIdentifier.open(this.getClass().getName(), 5000);

			if (commPort instanceof SerialPort) {

				serialPort = (SerialPort) commPort;

//				serialPort.addEventListener(this);

				serialPort.notifyOnDataAvailable(true);

				serialPort.setSerialPortParams(9600, // ��żӵ�

						SerialPort.DATABITS_8, // ������ ��Ʈ

						SerialPort.STOPBITS_1, // stop ��Ʈ

						SerialPort.PARITY_NONE); // �и�Ƽ

				in = serialPort.getInputStream();

				bin = new BufferedInputStream(in);

				

				// ������ ������ ��Ʈ�� ����

				out = serialPort.getOutputStream();

			} else {

				System.out.println("Error: Only serial ports are handled by this example.");

			}

		}

	}
	
	public void serialEvent(SerialPortEvent event) {

		switch (event.getEventType()) {

		case SerialPortEvent.BI:

		case SerialPortEvent.OE:

		case SerialPortEvent.FE:

		case SerialPortEvent.PE:

		case SerialPortEvent.CD:

		case SerialPortEvent.CTS:

		case SerialPortEvent.DSR:

		case SerialPortEvent.RI:

		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:

			break;

		case SerialPortEvent.DATA_AVAILABLE:

			byte[] readBuffer = new byte[128];

 

			try {

 

				while (bin.available() > 0) {

					int numBytes = bin.read(readBuffer);

				}

 

				String ss = new String(readBuffer);

				System.out.println("Receive Low Data:" + ss + "||");
				
				
				
				
			} catch (Exception e) {

				e.printStackTrace();

			}

			break;

		}

	}
	
	
	public void close() throws IOException {

		try {

			Thread.sleep(100);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		if (in != null) {

			in.close();

		}

		if (out != null) {

			out.close();

		}

		if (commPort != null) {

			commPort.close();

		}

 

	}

 

	
	public void sendIoT(String cmd) {
		Thread t1 = new Thread(new sendIoT(cmd));
		t1.start();
	}
	
	class sendIoT implements Runnable{
		String cmd;
		public sendIoT(String cmd) {
			this.cmd = cmd;
		}
		@Override
		public void run() {
			byte[] datas = cmd.getBytes();
			try {
				out.write(datas);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	// Client ���� �� Serial ��Ʈ ����
	public Client(String address, int port, String id) throws Exception {
		this.address = address;
		this.port = port;
		this.id = id;
		portIdentifier = CommPortIdentifier.getPortIdentifier("COM5");

		System.out.printf("Port Connect : %s\n", "COM5");

		connectSerial();
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

	
	// �޼����� �Է¹���
	public void sendMsg(String ss) {
//		Scanner sc = new Scanner(System.in);
//		while(true){
//			System.out.println("Input msg");
//			String ms = sc.nextLine();
//			
//			// 1�� ������ ���������� ����� ����Ʈ�� ������.
//			Msg msg = null;
//			if(ms.equals("1")) {
//				msg = new Msg(id, ms);
//				
//			}else {
//				// �ӼӸ� �ϰ����ϴ� ����� ip �ּ� ����
//				ArrayList<String> ips = new ArrayList<>();
//				ips.add("/172.30.1.27");
//				//msg = new Msg(ips,id,ms);
//				
//				// ��ο��� ���� ��
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

	
	// �޼��� ����
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
					// ������ �׾� ���� ��
					// �� �̻��� �޼����� ������ ���� �� ������ ����.
					//e.printStackTrace();
					
					try {
						if(socket != null) {
							socket.close();
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
					
					try {
						// �ٽ� ������ ���� �õ� 
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
					
					// mobile client���� ���� �޼����� IoT Client�� ����
					sendIoT(msg.getMsg());
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

	
	
	public static void main(String[] args) {
		try {
			Client client = new Client("192.168.0.17", 5555, "[Jeong]");

			client.connect();
			//client.sendMsg(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//send();
	}

}