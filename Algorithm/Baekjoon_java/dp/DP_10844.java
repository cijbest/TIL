package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10844] 쉬운 계단 수
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		long[][] dp = new long[n+1][10];
		for(int i = 1; i <= 9 ; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0)
					dp[i][j] = dp[i-1][j+1] % 1_000_000_000;
				else if(j == 9)
					dp[i][j] = dp[i-1][j-1] % 1_000_000_000;
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])  % 1_000_000_000;
			}
		}
		
		long answer = 0;
		for(int i = 0; i <= 9; i++) {
			answer += dp[n][i];
		}
		System.out.println(answer % 1_000_000_000);
	}

}
