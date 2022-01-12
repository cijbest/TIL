package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1932_�ݺ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1932] ���� �ﰢ��_Bottom-up
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] Cost = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while(st.hasMoreTokens()) {
				Cost[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Cost[0][0]; // �� ���� ���� ���������Ѵ�!!!
		for(int row = 1 ; row < N; row++) {
			for(int col = 0; col <= row; col++) {
				if(col == 0) {
					// �� �տ� ��ġ�� �ִ� ��
					Cost[row][col] += Cost[row-1][col];
				}
				else if(col == row) {
					// �� �ڿ� ��ġ�� �ִ� ��
					Cost[row][col] += Cost[row-1][col-1];
				}
				else {
					// �߰��� ��ġ�� �ִ� ��
					Cost[row][col] += Math.max(Cost[row-1][col-1], Cost[row-1][col]);
				}
				
				if(Cost[row][col] > max) max = Cost[row][col];
			}
		}
		
		System.out.println(max);

	}

}
