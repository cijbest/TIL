package backtracking;

import java.util.*;
import java.io.*;

public class BT_1248 {
	static int n;
	static int[][] s;
	static int[] ans;
	
	// s[idx][idx] ������ ���ڸ� ã�� ����̴�.
	static boolean go(int idx) {
		// n�̸� ��
		if(idx == n) {
			return true;
		}
		// 1) 0�� ���� 0���ۿ� �� ��
		if(s[idx][idx] == 0) {
			ans[idx] = 0;
			return check(idx) && go(idx+1); // ���̶� ����.
		}
		// 2) 0�� �ƴϰ� ���ڰ� �;��ϴ� ���
		for(int i = 1; i <= 10; i++) {
			ans[idx] = s[idx][idx] * i; // ���ڸ� �� �������� �ʰ� �ش� �ε����� ��ȣ�� ���ڿ� �����ؼ� ã�´�.
			if(check(idx) && go(idx+1)) return true; // ���� ���鵵 ������ true
		}
		return false;
	}
	
	// �ش� �ε��������� �հ� s���� ������ Ȯ��
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
		// [1248] �����
		// s[idx][idx] == ans[idx] ������ ���� �˰����� Ǭ��.
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
