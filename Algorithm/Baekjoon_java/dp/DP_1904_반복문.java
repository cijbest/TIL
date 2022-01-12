package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1904_반복문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1904] 01타일
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] DP = new int[1000001];
		
		DP[1] = 0;
		DP[1] = 1;
		DP[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			DP[i] = (DP[i-1] + DP[i-2]) % 15746;
		}
		
		System.out.println(DP[N]);

	}

}
