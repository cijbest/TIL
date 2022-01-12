package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1904 {
	
	static int[] DP = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1904] 01타일
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		// 초기화
		DP[1] = 0;
		DP[1] = 1;
		DP[2] = 2;
		
		for(int i = 3; i < DP.length; i++) {
			DP[i] = -1;
		}
		
		System.out.println(Tile(N));

	}
	
	static int Tile(int N) {
		if(DP[N] == -1) {
			DP[N] = (Tile(N-1) + Tile(N-2)) % 15746;
		}
		
		return DP[N];
	}

}
