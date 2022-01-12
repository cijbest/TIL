package recursion;

import java.util.*;
import java.io.*;

public class R_1759 {
	static void go(int L, String[] alpha, String password, int i) {
		// 정답을 찾은 경우
		if(L == password.length()) {
			if(check(password)) { // 조건 확인 : 모음 1개 이상, 자음 2개 이상
				System.out.println(password);
				return;
			}
		}
		// 불가능한 경우
		if(i >= alpha.length) {
			return;
		}
		// 다음 경우
		// i번째 알파벳 사용
		go(L, alpha, password+alpha[i], i+1);
		// i번째 알파벳 사용X
		go(L, alpha, password, i+1);
	}
	// 조건 확인 함수
	static boolean check(String password) {
		int mo = 0;
		int ja = 0;
		for(int i = 0; i < password.length(); i++) {
			char s = password.charAt(i);
			if(s == 'a' | s == 'e' | s == 'i' | s == 'o' | s == 'u')
				mo++;
			else
				ja++;
		}
		if(mo >= 1 && ja >= 2)
			return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		// [1759] 암호 만들기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] alpha = bf.readLine().split(" ");

		// 알파벳이 순서대로 증가한다고 했으므로 정렬
		Arrays.sort(alpha);
		go(L, alpha, "", 0);

	}

}
