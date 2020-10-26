package com.sync;

// 입급을 처리하는 스레드
public class Dth extends Thread {
	Account acc;
	public Dth(Account acc ) {
		this.acc = acc;
	}
	@Override
	public void run() {
		while(acc.getBalance() >= 0) {
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int money = (int)(Math.random() * 9 + 1) * 100;
			acc.deposit(money);
			System.out.println(acc);
		}
	}
	
	
}
