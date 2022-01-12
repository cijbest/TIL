package backtracking;

import java.util.*;
import java.io.*;

public class BT_2661 {
	static int n;
	
	static void go(int size, String num) {
		// n개의 수열이 되면 출력하고 프로그램 종료 => 가장 작은 숫자는 가장 먼저 나오는 숫자이므로
		if(size == n) {
			System.out.println(num);
			System.exit(0);
		}

		for(int i = 1; i <= 3; i++) {
			// 숫자를 추가할 때마다 좋은 수열인지 확인
			if(check(num+Integer.toString(i))) {
				go(size+1, num+Integer.toString(i));
			}
		}
	}
	static boolean check(String num) {
		int len = num.length();
		for(int i = 1; i <= len/2; i++) { // n/2 만큼의 크기만 조사
			String front = num.substring(len-i-i, len-i);
			String behind = num.substring(len-i, len);
			if(front.equals(behind)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2661] 좋은수열
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		go(0, "");
	}

}
