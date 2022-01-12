package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1463 {
	public static int[] dp;
	public static int go(int n) {
		if(n == 1)
			return 0;
		// go(n-1), go(n/2), go(n/3) ī��� ��ȯ �κ� (�̹� ���ߴٴ� �ǹ�)
		if(dp[n] > 0)
			return dp[n];
		dp[n] = go(n-1) + 1; // �� �κп��� ��� dp ���� �� ���� ���
		if(n % 2 == 0) {
			int tmp = go(n/2) + 1;
			if(dp[n] > tmp) {
				dp[n] = tmp;
			}
		}
		if(n % 3 == 0) {
			int tmp = go(n/3) + 1;
			if(dp[n] > tmp) {
				dp[n] = tmp;
			}
		}	
		return dp[n];
		
	}

	public static void main(String[] args) throws IOException {
		// [1463] 1�� �����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		dp = new int[n + 1];
		dp[1] = 0;
		
		// Bottom-Up
		for(int i = 2; i <= n; i++) {
			// long min = (int)Math.pow(10, 6) + 1;
			
			// -1�� �۾��� ������ �񱳴�� ���Ƿ� �켱������ ����ϰ� �� ������ �ּҰ��� ã���� �ȴ�.
			// Math.min()�� ���� �ʰ� ��Һ񱳸� �������� �־��ָ� �� �����ϴ�.
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0 && dp[i] > dp[i/2] + 1)
				dp[i] = dp[i/2] + 1;
			if(i % 3 == 0 && dp[i] > dp[i/3] + 1)
				dp[i] = dp[i/3] + 1;	
		}
		System.out.println(dp[n]);
		
		// Top - Down
		System.out.println(go(n));
	}

}
