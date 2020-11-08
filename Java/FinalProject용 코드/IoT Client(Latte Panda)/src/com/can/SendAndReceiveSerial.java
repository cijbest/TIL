package com.can;

 

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.chat.Client;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

 

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

				serialPort.setSerialPortParams(921600, // 통신속도

						SerialPort.DATABITS_8, // 데이터 비트

						SerialPort.STOPBITS_1, // stop 비트

						SerialPort.PARITY_NONE); // 패리티

				in = serialPort.getInputStream();

				bin = new BufferedInputStream(in);

				

				// 밖으로 나가는 스트림 생성

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

			//처음에  프로토콜 장비에 추가하겠다.

			this.data = ":G11A9\r";

		}

 

		public SerialWriter(String serialData) {

			// CheckSum Data 생성

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

				

				// can 통신에 참여할게!

				out.write(inputData);

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

 

	}

 

	

 

	

	// Asynchronized Receive Data

	// --------------------------------------------------------

	// 이벤트를 실행하면 얘가 실행된다.

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

				client.sendTarget("192.168.0.17", ss);
				//System.out.println("ddd" + ss);

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

 

	

 

	public static void main(String args[]) throws IOException {

		SendAndReceiveSerial ss = new SendAndReceiveSerial("COM10", true);

		
		ss.sendSerial("W2810003B010000000000005011", "10"

				+ "003B01");
		

		//ss.close();

 

	}

 

}