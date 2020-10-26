package com.sync;

// 출급을 처리하는 스레드
public class Wth extends Thread {
	Account acc;
	public Wth(Account acc ) {
		this.acc = acc;
	}
	@Override
	public void run() {
		while(acc.getBalance() >= 0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int money = (int)(Math.random() * 9 + 1) * 100;
			acc.withdraw(money);
			System.out.println(acc);
		}
	}
}
