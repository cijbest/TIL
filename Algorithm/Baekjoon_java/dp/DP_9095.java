package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_9095 {

	// 재귀 방식으로 해보기 
	static int go(int sum, int goal) {
		// 불가능한 경우
		if(sum > goal)
			return 0;
		// 정답을 찾은 경우
		if(sum == goal)
			return 1;
		// 다음 경우 호출
		int now = 0;
		for(int i = 1; i <= 3; i++) {
			now += go(sum+i, goal);
		}
		return now;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [9095] 1, 2, 3 더하기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		int[] dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int t = 0; t < T; t++) {
			int n = Integer.valueOf(bf.readLine());
			
			for(int i = 4; i <= 10; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}

			System.out.println(dp[n]);
		}
		
		// 재귀방식
		while(T-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(go(0, n));
		}
		
	}

}
