package com.thread;

class TT extends Thread{

	@Override
	public void run() {
		while(true) {
			System.out.println("Thread ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Test4 {

	public static void main(String[] args) throws InterruptedException {

		TT t = new TT();
		// 메인 애플리케이션이 죽을 때 같이 죽음
		t.setDaemon(true);
		t.start();
		Thread.sleep(10000);
		System.out.println("End Application .....");
	}

}
 