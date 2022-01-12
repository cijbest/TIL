package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_10872_for¹® {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10872] ÆÑÅä¸®¾ó
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int ans = 1;
		for(int i = 1; i <= n; i++) {
			ans *= i;
		}
		
		System.out.println(ans);

	}

}
