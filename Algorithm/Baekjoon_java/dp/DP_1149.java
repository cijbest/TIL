package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1149 {
	
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
	
	static int[][] Cost;
	static int[][] DP;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1149] RGB거리
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		Cost = new int[N][3];
		DP = new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			Cost[i][Red] = Integer.parseInt(st.nextToken());
			Cost[i][Green] = Integer.parseInt(st.nextToken());
			Cost[i][Blue] = Integer.parseInt(st.nextToken());
		}
		
		
		// DP 첫번째 값 초기화
		DP[0][Red] = Cost[0][Red];
		DP[0][Green] = Cost[0][Green];
		DP[0][Blue] = Cost[0][Blue];
		
		System.out.println(Math.min(Paint_cost(N-1, Red), Math.min(Paint_cost(N-1, Green), Paint_cost(N-1, Blue))));

	}
	
	static int Paint_cost(int N, int color) {
		if(DP[N][color] == 0) {
			if(color == Red) {
				DP[N][Red] = Cost[N][Red] + Math.min(Paint_cost(N-1, Green), Paint_cost(N-1, Blue));
			}
			else if(color == Green) {
				DP[N][Green] = Cost[N][Green] + Math.min(Paint_cost(N-1, Red), Paint_cost(N-1, Blue));
			}
			else {
				DP[N][Blue] = Cost[N][Blue] + Math.min(Paint_cost(N-1, Red), Paint_cost(N-1, Green));
			}
		}
		
		return DP[N][color];
	}

}
