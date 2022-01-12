package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_10871_배열 {
	
	static int[] num;
	
	public static int fibo(int n) {
		if(n <= 1) 
			return n;
		
		if(num[n] != 0) 
			return num[n];

		num[n] = fibo(n-1) + fibo(n-2);
		return num[n];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10870] 피보나치 수 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		System.out.println(fibo(n));
		

	}

}
