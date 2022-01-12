package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11054_반복문 {
	static int N;
	static int[] seq;
	static int[] i_dp;
	static int[] d_dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11054] 가장 긴 바이토익 부분 수열_Bottom-up
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			
		}
		
		i_dp = new int[N]; // 오른쪽으로 증가한 수열 길이 최대값
		d_dp = new int[N]; // 왼쪽으로 감소한 수열 길이 최대값
		
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
			i_dp[i] = 1; // 1로 초기화
			
			for(int j = 0; j < i; j++) {
				
				if(seq[i] > seq[j] && i_dp[i] < i_dp[j]+1) {
					i_dp[i] = i_dp[j] + 1;
				}
			}
		}
	}
	
	static void LDS() {
		
		for(int i = N-1; i >= 0; i--) {
			d_dp[i] = 1; // 1로 초기화
			
			for(int j = N-1; j > i; j--) {
				
				if(seq[i] > seq[j] && d_dp[i] < d_dp[j]+1) {
					d_dp[i] = d_dp[j] + 1;
				}
			}
		}
	}

}
