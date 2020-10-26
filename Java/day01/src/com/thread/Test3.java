package com.thread;

import java.util.Scanner;

class Thread1 implements Runnable {

	boolean flag;
	
	public Thread1(){}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		System.out.println("Start");
		while(true) {
			if(flag == false) {
				System.out.println("stop ...");
				break;
			}
			//System.out.println("Connecting ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}
}


public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		// Runnable 객체 (이걸 쓰면 쓰레드를 계속 생성할 필요가 없어진다.)
		Thread1 r = new Thread1();
		// Thread 객체
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input Cmd");
			String cmd = sc.nextLine();
			if(cmd.contentEquals("start")){
				t1 = new Thread(r);
				t1.start();
			}else if(cmd.equals("stop")){
				r.setFlag(false);
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("Exit Application...");
		
		
		//		Thread1 t1 = new Thread1();
//		t1.start();
//		Thread.sleep(10000);
//		t1.setFlag(false);

	}

}
