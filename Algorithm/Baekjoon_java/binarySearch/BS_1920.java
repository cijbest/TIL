package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BS_1920 {
	public static int[] a;
	public static int find(int num, int first, int end) {
		if (first > end)
			return 0;
		int mid = (first+end) / 2;
		if (a[mid] > num)
			return find(num, first, mid-1);
		else if (a[mid] < num)
			return find(num, mid+1, end);
		else
			return 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1920] �� ã��
		// ����Ž���� �ٽ��� �߰����� ã�� �� ���� ���� ã�� ������ Ȯ���� �Ŀ�
		// �ƴ϶�� �߰����� �������� �� �� ������ �� Ž���ϴ� ��
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.valueOf(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		Arrays.sort(a);
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(find(num, 0, n-1) + "\n");
		}		
		System.out.println(sb);
	}

}
