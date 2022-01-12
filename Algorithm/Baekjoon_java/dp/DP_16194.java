package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_16194 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [16194] ī�� �����ϱ�2
		// ī�带 �� �徿 ���鼭 ���� ī���� dp���� �� ī���� p���� �� ���� �� �ּҰ��� �������� ���Ѵ�.
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
