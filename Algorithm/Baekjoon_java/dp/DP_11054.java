package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11054 {
	static int N;
	static int[] seq;
	static Integer[] i_dp;
	static Integer[] d_dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11054] ���� �� �������� �κ� ����_Top-down
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			
		}
		
		i_dp = new Integer[N]; // ���������� ������ ���� ���� �ִ밪
		d_dp = new Integer[N]; // �������� ������ ���� ���� �ִ밪
		
		for(int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(i_dp[i] + d_dp[i] > max) {
				max = i_dp[i] + d_dp[i];
			}
		}
		
		System.out.println(max - 1);
	}
	
	static int LIS(int N) {
		if(i_dp[N] == null) { // Ž������ �ʾ��� ��
			i_dp[N] = 1; // 1�� �ʱ�ȭ
			
			for(int i = N-1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					i_dp[N] = Math.max(i_dp[N], LIS(i) + 1);
				}
			}
		}
		return i_dp[N];
	}
	
	static int LDS(int N) {
		if(d_dp[N] == null) { // Ž������ �ʾ��� ��
			d_dp[N] = 1; // 1�� �ʱ�ȭ
			
			for(int i = N+1; i < d_dp.length; i++) {
				if(seq[i] < seq[N]) {
					d_dp[N] = Math.max(d_dp[N], LDS(i) + 1);
				}
			}
		}
		return d_dp[N];
	}

}
