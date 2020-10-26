package com.thread;

class Th1 extends Thread{
	int sum;
	@Override
	public void run() {
		for(int i = 1 ; i <= 20; i++) {
			System.out.println("TH1 .....");
			sum += i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getSum() {
		return sum;
	}
}

class Th2 extends Thread{
	int sum;
	@Override
	public void run() {
		for(int i = 1 ; i <= 40; i++) {
			System.out.println("TH2 .....");
			sum += i;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getSum() {
		return sum;
	}
}

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		// join 해당 스레드가 끝날 때까지 기다린다.
		// join을 해주지 않으면 쓰레드는 바로 밑의 코드를 실행하므로 작동이 다 안 된 상태에서 끝나게 됨
				
		
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		
		System.out.println("START");
		
		th1.start();
		System.out.println("TH1 STARTED");
		th1.join();
		th2.start();
		System.out.println("TH2 STARTED");
		
		
		th2.join();
		System.out.println(th1.getSum() + " " + th2.getSum());
		System.out.println(th1.getSum() + th2.getSum());
	}

}
