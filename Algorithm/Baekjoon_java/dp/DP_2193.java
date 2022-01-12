package dp;

import java.io.*;

public class DP_2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2193] ÀÌÄ£¼ö
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		long[][] dp = new long[n+1][2];
		dp[1][1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		System.out.println(dp[n][0] + dp[n][1]);
	}

}
