package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1699] 제곱수의 합
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dp[i] = i; // 최댓값으로 초기 설정
			for(int j = 1; j*j <= i; j++) {
				if(dp[i-(j*j)] + 1 < dp[i]) {
					dp[i] = dp[i-(j*j)] + 1;
				}
			}
		}
		System.out.println(dp[n]);

	}

}
