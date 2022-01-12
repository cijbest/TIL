package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DP_2565_�ݺ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2565] ������_Bottom-up
		// (��ü ���� ���� - ��ġ ���� ����) = ö�� ����
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
