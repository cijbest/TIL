package com.sus;

import java.util.Scanner;

// 밖에 스레드를 만들면 Test에 있는 데이터를 공유x
class Th extends Thread{

	boolean stop = false;
	boolean sus = false;
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void setSus(boolean sus) {
		this.sus = sus;
	}
	
	@Override
	public void run() {
		while(true) {
			if(stop == true) {
				System.out.println("Stop Thread ...");
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(sus != true) {
				System.out.println("Downloading ...");
			}
		}
		System.out.println("End Thread ...");
	}
	
}

public class Test {
	
	// 밖에 스레드를 만들면 Test에 있는 데이터를 공유o
	
	public static void main(String[] args) {

		Th th = new Th();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd");
			String cmd = sc.nextLine();
			if(cmd.equals("start")) {
				th = new  Th();
				th.start();
			}else if(cmd.equals("stop")) {
				th.setStop(true);
			}else if(cmd.equals("sus")) {
				th.setSus(true);
			}else if(cmd.equals("res")) {
				th.setSus(false);
			}else if(cmd.equals("q")) {
				th.setStop(true);
				break;
			}
		}
		System.out.println("End App");
		
	}

}
