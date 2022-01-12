package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2156_�ݺ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2156] ������ �ý�_Bottom-up
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] cup = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			cup[i] = Integer.parseInt(br.readLine());
		}
		
		// �ʱ�ȭ
		dp[1] = cup[1];
		
		// N=1�� �� dp[2]�� �����Ƿ� ���� �߻�
		if(N > 1)
			dp[2] = cup[1] + cup[2];
		
		// ���
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(Math.max(dp[i-3]+cup[i-1]+cup[i], dp[i-2]+cup[i]), dp[i-1]);
		}
		
		System.out.println(dp[N]);

	}

}
