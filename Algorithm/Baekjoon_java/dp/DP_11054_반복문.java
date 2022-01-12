package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11054_�ݺ��� {
	static int N;
	static int[] seq;
	static int[] i_dp;
	static int[] d_dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11054] ���� �� �������� �κ� ����_Bottom-up
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			
		}
		
		i_dp = new int[N]; // ���������� ������ ���� ���� �ִ밪
		d_dp = new int[N]; // �������� ������ ���� ���� �ִ밪
		
		LIS();
		LDS();
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(i_dp[i] + d_dp[i] > max) {
				max = i_dp[i] + d_dp[i];
			}
		}
		
		System.out.println(max - 1);
	}
	
	static void LIS() {
		
		for(int i = 0; i < N; i++) {
			i_dp[i] = 1; // 1�� �ʱ�ȭ
			
			for(int j = 0; j < i; j++) {
				
				if(seq[i] > seq[j] && i_dp[i] < i_dp[j]+1) {
					i_dp[i] = i_dp[j] + 1;
				}
			}
		}
	}
	
	static void LDS() {
		
		for(int i = N-1; i >= 0; i--) {
			d_dp[i] = 1; // 1�� �ʱ�ȭ
			
			for(int j = N-1; j > i; j--) {
				
				if(seq[i] > seq[j] && d_dp[i] < d_dp[j]+1) {
					d_dp[i] = d_dp[j] + 1;
				}
			}
		}
	}

}
