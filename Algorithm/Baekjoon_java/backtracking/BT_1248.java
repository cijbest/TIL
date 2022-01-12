package backtracking;

import java.util.*;
import java.io.*;

public class BT_1248 {
	static int n;
	static int[][] s;
	static int[] ans;
	
	// s[idx][idx] 가지고만 숫자를 찾는 방법이다.
	static boolean go(int idx) {
		// n이면 끝
		if(idx == n) {
			return true;
		}
		// 1) 0인 경우는 0값밖에 못 들어감
		if(s[idx][idx] == 0) {
			ans[idx] = 0;
			return check(idx) && go(idx+1); // 밑이랑 같다.
		}
		// 2) 0이 아니고 숫자가 와야하는 경우
		for(int i = 1; i <= 10; i++) {
			ans[idx] = s[idx][idx] * i; // 숫자를 다 대입하지 않고 해당 인덱스의 부호를 숫자와 경합해서 찾는다.
			if(check(idx) && go(idx+1)) return true; // 다음 값들도 맞으면 true
		}
		return false;
	}
	
	// 해당 인덱스까지의 합과 s값이 같은지 확인
	static boolean check(int idx) {
		int sum = 0;
		for(int i = idx; i >= 0; i--) {
			sum += ans[i];
			if(s[i][idx] == 0) {
				if(sum != 0) return false;
			}
			else if(s[i][idx] > 0) {
				if(sum <= 0) return false;
			}
			else if(s[i][idx] < 0) {
				if(sum >= 0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		// [1248] 맞춰봐
		// s[idx][idx] == ans[idx] 같음을 토대로 알고리즘을 푼다.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		s = new int[n][n];
		ans = new int[n];
		
		String tmp = bf.readLine();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				char x = tmp.charAt(cnt++);
				if(x == '0') {
					s[i][j] = 0;
				}
				else if(x == '+') {
					s[i][j] = 1;
				}
				else if(x == '-') {
					s[i][j] = -1;
				}
			}
		}
		go(0);
		for(int x : ans) {
			System.out.print(x + " ");
		}
	}

}
