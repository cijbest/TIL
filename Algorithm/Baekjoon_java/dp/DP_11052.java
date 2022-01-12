package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11052] ī�� �����ϱ�
		// ī�带 �� �徿 ���鼭 ���� ī���� dp���� �� ī���� p���� �� ���� �� �ִ밪�� �������� ���Ѵ�.
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
				dp[i] = Math.max(dp[i-j] + p[j], dp[i]);
			}
		}
		System.out.println(dp[n]);

	}

}
