package backtracking;

import java.util.*;
import java.io.*;

public class BT_1182 {
	static int n, s, cnt = 0;
	static int[] a;
	
	static void go(int idx, int sum) {
		// 조건 확인
		if(idx == n) {
			if(sum == s) cnt++;
			return;
		}
		// 다음 경우
		go(idx+1, sum+a[idx]);
		go(idx+1, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1182] 부분수열의 합
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		go(0, 0);
		
		// 완전 주의!!) 처음부터 끝까지 아무것도 선택 안함의 상태가 되면 빈배열 즉, 공집합이 나오는데
		// 이때 sum의 기본값이 0이므로 s가 0일 경우에 정답이 1개 더 있다고 카운팅된다.
		// 그러므로 s가 0이면 -1을 해주어 공집합을 제거해준다.
		System.out.println(s == 0? cnt-1 : cnt);

	}

}
