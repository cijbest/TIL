package basic;

public class Fibonacci {
	static int[] fibo;
	
	static int fibo(int n) {
		if(n <= 1) { 
			return n;
		}
		else {
			if(fibo[n] > 0) {
				return fibo[n];
			}
			fibo[n] = fibo(n-1) + fibo(n-2);
			return fibo[n];
		}
	}

	public static void main(String[] args) {
		// 피보나치
		int n = 5;
		fibo = new int[n+1];
		System.out.println(fibo(n));

	}

}
