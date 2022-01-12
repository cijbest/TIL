package twopointer;

import java.util.*;
import java.io.*;

public class TP_1806 {

	public static void main(String[] args) throws IOException {
		// [1806] �κ���
		// 1.�������� ������ ù��° ������ �ε����� ����Ű���� �Ѵ�.
		// 2.���� �κ� ���� M�� ���ٸ� ī��Ʈ�Ѵ�.
		// 3.���� �κ� ���� M���� �۴ٸ� end�� 1 ������Ų��.
		// 4.���� �κ� ���� M���� ũ�ų� ���ٸ� start�� 1 ������Ų��.
		// 5.��� ��츦 Ȯ���� ������ 2-4�� ������ �ݺ��Ѵ�.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		long sum = 0;
		int min = 100001;
		while (true) {
            if (sum >= s) { //���� ����
                sum -= a[start];
                min = Math.min(min, (end - start)); // �κ��� �ּ� ���� ����
                start++; // ���� ������ ���������� �̵�
            } else if (end == n) { //�� ����
                break;
            } else { // right������ ���������� �̵�
                sum += a[end++];
            }
        }
		if(min == 100001) System.out.println(0);
		else System.out.println(min);

	}

}
