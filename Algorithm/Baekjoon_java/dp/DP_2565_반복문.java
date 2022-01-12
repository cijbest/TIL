package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DP_2565_반복문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2565] 전깃줄_Bottom-up
		// (전체 전선 개수 - 설치 가능 개수) = 철거 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] wire = new int[N][2];
		int[] dp = new int[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// A전봇대 기준으로 정렬
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// A 전봇대 기준으로 정렬해놨기 때문에 연결된 B전봇대의 앞쪽만 검사하면 된다.
		// i번째 전봇대를 기준으로 이전 전봇대들의 전선을 연결하기 위한 탐색
		// i번째 전봇대에 연결된 B전봇대는 탐색할 j번째 전봇대에 연결된 B전봇대보다 값이 커야함
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(N - max);
		


	}

}
