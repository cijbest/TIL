package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_10872 {
	
	public static int factorial(int n) {
		if(n <= 1)
			return 1;
		return n * factorial(n-1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10872] ÆÑÅä¸®¾ó
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(n));

	}

}
