package com.sync;

public class Bank {

	public static void main(String[] args) {
		Account acc = new Account(3000);
		
		Dth dt = new Dth(acc);
		Wth wt = new Wth(acc);
		Dth dt2 = new Dth(acc);
		Wth wt2 = new Wth(acc);
		Dth dt3 = new Dth(acc);
		Wth wt3 = new Wth(acc);
		
		wt.start();
		dt.start();
		wt2.start();
		dt2.start();
		wt3.start();
		dt3.start();
		
		

	}

}
