package backtracking;

import java.util.*;
import java.io.*;

public class BT_1182_비트마스크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1182] 부분수열의 합
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i = 1; i < (1<<n); i++) { // 모든 경우의 수를 탐색
			int sum = 0;
			for(int k = 0; k < n; k++) { // 해당 비트마스크 탐색 위치 설정
				if((i & (1<<k)) != 0) { // k를 늘려가면서 i의 비트마스크의 어느 위치가 1인지 검사
					sum += a[k];
				}
			}
			if(sum == s) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
