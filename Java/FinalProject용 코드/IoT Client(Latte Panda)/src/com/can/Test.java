package com.can;

 

import java.io.IOException;

 

import gnu.io.CommPortIdentifier;

 

public class Test {

 

	private CommPortIdentifier portIdentifier;

	

 

	public Test(String portName, boolean mode) {

 

		try {

			if (mode == true) {

				portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

				System.out.printf("Port Connect : %s\n", portName);

				

			}

 

		} catch (Exception e) {

			e.printStackTrace();

		}

 

	}

 

 

 

	public static void main(String args[]) throws IOException {

 

		Test ss = new Test("COM9", true);

 

	}

 

}