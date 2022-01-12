package backtracking;

import java.util.*;
import java.io.*;

public class BT_1182 {
	static int n, s, cnt = 0;
	static int[] a;
	
	static void go(int idx, int sum) {
		// ���� Ȯ��
		if(idx == n) {
			if(sum == s) cnt++;
			return;
		}
		// ���� ���
		go(idx+1, sum+a[idx]);
		go(idx+1, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1182] �κм����� ��
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
		
		// ���� ����!!) ó������ ������ �ƹ��͵� ���� ������ ���°� �Ǹ� ��迭 ��, �������� �����µ�
		// �̶� sum�� �⺻���� 0�̹Ƿ� s�� 0�� ��쿡 ������ 1�� �� �ִٰ� ī���õȴ�.
		// �׷��Ƿ� s�� 0�̸� -1�� ���־� �������� �������ش�.
		System.out.println(s == 0? cnt-1 : cnt);

	}

}
