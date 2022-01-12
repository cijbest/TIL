package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_11726 {
	public static int[] dp;
	public static int go(int n) {
		if(dp[n] > 0)
			return dp[n];
		dp[n] = (go(n-1) + go(n-2)) % 10007;
		return dp[n];
				
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11726] 2xn ≈∏¿œ∏µ
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		
		dp = new int[n+1];
		// Buttom-Up
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007;
		}
		System.out.println(dp[n]);
		
		// Top-Down
		System.out.println(go(n));
 
	}

}
