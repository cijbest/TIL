package com.sync;

public class Account {
	private int balance;
	public Account() {}
	public Account(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public synchronized void deposit(int money) { // 임계 영역안에 다른 사용자가 접근하지 못하게 한다.
		if(money > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance += money;
		}
	}
	public void withdraw(int money) {
		synchronized(this) { // 위의 synchronized랑 같은 것임. 모양만 다를 뿐
			if(balance >= money) {
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				balance -= money;
			}
		}
		
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
}
