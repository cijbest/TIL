package com.can;

 

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.chat.Client;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

 
/* Serial ������� �����͸� �ְ� �޴� �ڵ� */
public class SendAndReceiveSerial implements SerialPortEventListener {

	private BufferedInputStream bin;

	private InputStream in;

	private OutputStream out;

	private SerialPort serialPort;

	private CommPortIdentifier portIdentifier;

	private CommPort commPort;

	private String result;

	private String rawCanID, rawTotal;

	// private boolean start = false;
	private  Client client;

 

	public SendAndReceiveSerial(String portName, boolean mode) {

		client = new Client("192.168.0.17", 5555, "[can]");
		try {
			client.connect();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			if (mode == true) {

				portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

				System.out.printf("Port Connect : %s\n", portName);

				connectSerial();

				// Serial Initialization ....

				(new Thread(new SerialWriter())).start();

			}

 

		} catch (Exception e) {

			e.printStackTrace();

		}

 

	}

 

	public void connectSerial() throws Exception {

 

		if (portIdentifier.isCurrentlyOwned()) {

			System.out.println("Error: Port is currently in use");

		} else {

			commPort = portIdentifier.open(this.getClass().getName(), 5000);

			if (commPort instanceof SerialPort) {

				serialPort = (SerialPort) commPort;

				serialPort.addEventListener(this);

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

 

	public void sendSerial(String rawTotal, String rawCanID) {

		this.rawTotal = rawTotal;

		this.rawCanID = rawCanID;

		// System.out.println("send: " + rawTotal);

		try {

			// Thread.sleep(50);

			Thread.sleep(30);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		Thread sendTread = 

				new Thread(new SerialWriter(rawTotal));

		sendTread.start();

	}

 

	private class SerialWriter implements Runnable {

		String data;

 

		public SerialWriter() {

			// �������� ��� �߰��ϴ� ���� ����

			this.data = ":G11A9\r";

		}

 

		public SerialWriter(String serialData) {

			// CheckSum Data ����

			this.data = sendDataFormat(serialData);

		}

 

		public String sendDataFormat(String serialData) {

			serialData = serialData.toUpperCase();

			char c[] = serialData.toCharArray();

			int cdata = 0;

			for (char cc : c) {

				cdata += cc;

			}

			cdata = (cdata & 0xFF);

 

			String returnData = ":";

			returnData += serialData + Integer.toHexString(cdata).toUpperCase();

			returnData += "\r";

			return returnData;

		}

 

		public void run() {

			try {

 

				byte[] inputData = data.getBytes();

				

				// can ��ſ� �����Ұ�!

				out.write(inputData);

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

 

	}

 

	

 

	

	// Asynchronized Receive Data

	// --------------------------------------------------------

	// �����Ͱ� Serial ��Ʈ�� ���� ������(�̺�Ʈ �߻�) ����Ǵ� �Լ�

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
				
				
				// ������ serial data ����
				client.sendTarget("192.168.0.17", ss);

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

 

	// Serial ��η� �����͸� ������ �Լ�
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
 

	public static void main(String args[]) throws IOException {

		SendAndReceiveSerial ss = new SendAndReceiveSerial("COM5", true);
		
		//ss.sendIoT();
		
		

 

	}

 

}