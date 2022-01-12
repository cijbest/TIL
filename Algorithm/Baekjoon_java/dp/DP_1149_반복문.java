package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1149_반복문 {
	
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
	
	static int[][] Cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1149] RGB거리
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		Cost = new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			Cost[i][Red] = Integer.parseInt(st.nextToken());
			Cost[i][Green] = Integer.parseInt(st.nextToken());
			Cost[i][Blue] = Integer.parseInt(st.nextToken());
		}
		
		// Cost값을 누적합으로 대체 : 이것도 메모이제이션!!
		for(int i = 1; i < N; i++) {
			Cost[i][Red] += Math.min(Cost[i-1][Green], Cost[i-1][Blue]); 
			Cost[i][Green] += Math.min(Cost[i-1][Red], Cost[i-1][Blue]); 
			Cost[i][Blue] += Math.min(Cost[i-1][Red], Cost[i-1][Green]); 
		}
	
		
		System.out.println(Math.min(Cost[N-1][Red], Math.min(Cost[N-1][Green], Cost[N-1][Blue])));

	}
	

}
