package backtracking;

import java.util.*;
import java.io.*;

public class BT_1182_��Ʈ����ũ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1182] �κм����� ��
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
		for(int i = 1; i < (1<<n); i++) { // ��� ����� ���� Ž��
			int sum = 0;
			for(int k = 0; k < n; k++) { // �ش� ��Ʈ����ũ Ž�� ��ġ ����
				if((i & (1<<k)) != 0) { // k�� �÷����鼭 i�� ��Ʈ����ũ�� ��� ��ġ�� 1���� �˻�
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
