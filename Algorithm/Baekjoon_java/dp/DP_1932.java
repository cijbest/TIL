package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1932 {
	
	static int N;
	static int[][] Cost;
	static Integer[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1932] ���� �ﰢ��_Top-down
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Cost = new int[N][N];
		dp = new Integer[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while(st.hasMoreTokens()) {
				Cost[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ���� ���� �ʱ�ȭ
		for(int i = 0; i < N; i++) {
			dp[N-1][i] = Cost[N-1][i];
		}
		
		System.out.println(find(0, 0));
	}
	
	static int find(int row, int col) {
		// ������ ���� ��� ���� ��ġ�� dp�� ��ȯ
		if(row == N-1) return dp[row][col];
		
		if(dp[row][col] == null) {
			dp[row][col] = Math.max(find(row+1, col), find(row+1, col+1)) + Cost[row][col];
		}
		
		return dp[row][col];
	}

}
