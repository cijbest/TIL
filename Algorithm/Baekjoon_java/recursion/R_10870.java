package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_10870 {
	
	public static int fibo(int n) {
		if(n <= 1) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10870] 피보나치 수 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibo(n));
		

	}

}
