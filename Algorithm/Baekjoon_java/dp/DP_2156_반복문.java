package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2156_반복문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2156] 포도주 시식_Bottom-up
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] cup = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			cup[i] = Integer.parseInt(br.readLine());
		}
		
		// 초기화
		dp[1] = cup[1];
		
		// N=1일 때 dp[2]는 없을므로 에러 발생
		if(N > 1)
			dp[2] = cup[1] + cup[2];
		
		// 계산
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(Math.max(dp[i-3]+cup[i-1]+cup[i], dp[i-2]+cup[i]), dp[i-1]);
		}
		
		System.out.println(dp[N]);

	}

}
