package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DP_2565 {

	static int[][] wire;
	static Integer[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2565] 전깃줄_Top-down
		// (전체 전선 개수 - 설치 가능 개수) = 철거 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		wire = new int[N][2];
		dp = new Integer[N];
		
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
			recur(i);
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(N - max);
		
	}
	
	static int recur(int N) {
		
		// 탐색하지 않았던 위치라면 
		if(dp[N] == null) {
			
			dp[N] = 1;	// 최솟값 1로 초기화 
			
			// A의 N번째와 이후의 전봇대들 비교 
			for(int i = N + 1; i < dp.length; i++) {
				
				/*
				 *  A전봇대의 N번째 전선이 연결되어있는 B전봇대보다 A의 i번째
				 *  전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우 
				 *  전선을 설치할 수 있음 
				 */
				if(wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
					dp[N] = Math.max(dp[N], recur(i) + 1);
				}
			}
		}
		return dp[N];
	}

}
