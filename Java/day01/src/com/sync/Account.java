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
	
	public synchronized void deposit(int money) { // �Ӱ� �����ȿ� �ٸ� ����ڰ� �������� ���ϰ� �Ѵ�.
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
		synchronized(this) { // ���� synchronized�� ���� ����. ��縸 �ٸ� ��
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
