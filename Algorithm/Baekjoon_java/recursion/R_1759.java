package recursion;

import java.util.*;
import java.io.*;

public class R_1759 {
	static void go(int L, String[] alpha, String password, int i) {
		// ������ ã�� ���
		if(L == password.length()) {
			if(check(password)) { // ���� Ȯ�� : ���� 1�� �̻�, ���� 2�� �̻�
				System.out.println(password);
				return;
			}
		}
		// �Ұ����� ���
		if(i >= alpha.length) {
			return;
		}
		// ���� ���
		// i��° ���ĺ� ���
		go(L, alpha, password+alpha[i], i+1);
		// i��° ���ĺ� ���X
		go(L, alpha, password, i+1);
	}
	// ���� Ȯ�� �Լ�
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
		// [1759] ��ȣ �����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] alpha = bf.readLine().split(" ");

		// ���ĺ��� ������� �����Ѵٰ� �����Ƿ� ����
		Arrays.sort(alpha);
		go(L, alpha, "", 0);

	}

}
