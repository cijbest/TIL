package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2156 {
	
	static int[] cup;
	static Integer[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2156] ������ �ý�_Top-down
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cup = new int[N+1];
		dp = new Integer[N+1];
		
		for(int i = 1; i <= N; i++) {
			cup[i] = Integer.parseInt(br.readLine());
		}
		
		// �ʱ�ȭ
		dp[0] = 0; // Integer[] Ÿ���̹Ƿ� �ε��� 0�� �ʱ�ȭ�� �ʿ� 
		dp[1] = cup[1];
		
		// N=1�� �� dp[2]�� �����Ƿ� ���� �߻�
		if(N > 1)
			dp[2] = cup[1] + cup[2];
		
		// ���
		System.out.println(find(N));


	}
	
	static int find(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(Math.max(find(N-3)+cup[N-1]+cup[N], find(N-2)+cup[N]), find(N-1));
		}
		
		return dp[N];
	}

}
