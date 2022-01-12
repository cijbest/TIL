package recursion;

import java.util.*;
import java.io.*;

public class R_14501 {
	static int n;
	static int[] T, P;
	static int ans = 0;
	
	static void go(int day, int sum) {
		// 정답 찾은 경우
		if(day == n+1) {
			if(ans < sum) ans = sum;
			return;
		}
		// 불가능한 경우
		if(day > n+1) {
			return;
		}
		// 다음 경우 호출
		// 이날 상담O
		go(day+T[day], sum+P[day]);
		// 이날 상담X
		go(day+1, sum);
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [14501] 퇴사
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		T = new int[n+1];
		P = new int[n+1];
		for(int i = 1 ; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		go(1, 0);
		System.out.println(ans);
	}

}
