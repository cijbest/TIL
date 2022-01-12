package backtracking;

import java.util.*;
import java.io.*;

public class BT_2661 {
	static int n;
	
	static void go(int size, String num) {
		// n���� ������ �Ǹ� ����ϰ� ���α׷� ���� => ���� ���� ���ڴ� ���� ���� ������ �����̹Ƿ�
		if(size == n) {
			System.out.println(num);
			System.exit(0);
		}

		for(int i = 1; i <= 3; i++) {
			// ���ڸ� �߰��� ������ ���� �������� Ȯ��
			if(check(num+Integer.toString(i))) {
				go(size+1, num+Integer.toString(i));
			}
		}
	}
	static boolean check(String num) {
		int len = num.length();
		for(int i = 1; i <= len/2; i++) { // n/2 ��ŭ�� ũ�⸸ ����
			String front = num.substring(len-i-i, len-i);
			String behind = num.substring(len-i, len);
			if(front.equals(behind)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2661] ��������
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		go(0, "");
	}

}
