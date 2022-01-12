package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_16194 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [16194] 카드 구매하기2
		// 카드를 한 장씩 빼면서 남은 카드의 dp값과 뺀 카드의 p값을 더 했을 때 최소값이 무엇인지 비교한다.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int[] p = new int[n+1];
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(dp[i] == 0)
					dp[i] = dp[i-j] + p[j];
				dp[i] = Math.min(dp[i-j] + p[j], dp[i]);
			}
		}
		System.out.println(dp[n]);

	}

}
