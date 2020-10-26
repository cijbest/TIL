package com.thread;

class Th implements Runnable{
	
	String name;
	
	public Th(){}
	
	public Th(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0 ; i <= 100; i++) {
			System.out.println(name +":"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class Test2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Th("T1"));
		t1.start();
		t1.setPriority(10); // 우선순위 설정, 숫자가 클수록 우선순위가 높음
		Thread t2 = new Thread(new Th("T2"));
		t2.start();
		t2.setPriority(1);

	}

}
