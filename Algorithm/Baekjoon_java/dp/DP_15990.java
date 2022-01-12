package dp;

import java.io.*;

public class DP_15990 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [15990] 1, 2, 3 더하기 (보류)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[][] dp = new long[100_001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4; i <= 100_000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
		}
		
		int T = Integer.valueOf(bf.readLine());
		while(T-- > 0) {
			int n = Integer.valueOf(bf.readLine());
			sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % 1_000_000_009 + "\n");
			
		}

		System.out.println(sb);
		

	}

}
