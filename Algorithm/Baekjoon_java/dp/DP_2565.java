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
		// [2565] ������_Top-down
		// (��ü ���� ���� - ��ġ ���� ����) = ö�� ����
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
		
		// A������ �������� ����
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// A ������ �������� �����س��� ������ ����� B�������� ���ʸ� �˻��ϸ� �ȴ�.
		// i��° �����븦 �������� ���� ��������� ������ �����ϱ� ���� Ž��
		// i��° �����뿡 ����� B������� Ž���� j��° �����뿡 ����� B�����뺸�� ���� Ŀ����
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
		
		// Ž������ �ʾҴ� ��ġ��� 
		if(dp[N] == null) {
			
			dp[N] = 1;	// �ּڰ� 1�� �ʱ�ȭ 
			
			// A�� N��°�� ������ ������� �� 
			for(int i = N + 1; i < dp.length; i++) {
				
				/*
				 *  A�������� N��° ������ ����Ǿ��ִ� B�����뺸�� A�� i��°
				 *  �������� ������ �̾��� B�����밡 �ڿ� ���� ��� 
				 *  ������ ��ġ�� �� ���� 
				 */
				if(wire[N][1] < wire[i][1]) {
					// ���� ������ ������ ����� �� �� ū ���� dp�� �����Ѵ�.
					dp[N] = Math.max(dp[N], recur(i) + 1);
				}
			}
		}
		return dp[N];
	}

}
