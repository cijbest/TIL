package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1912] ¿¬¼ÓÇÕ
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int[] a = new int[n+1];
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		dp[1] = a[1];
		int max = a[1];
		for(int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i-1] + a[i], a[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

}
