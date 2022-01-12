package binarySearch;

import java.util.*;
import java.io.*;
public class BS_1654 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1654] ���� �ڸ���
		// UpperBound �̿��ؼ� �ִ밪�� ���Ѵ�.
		// min, max�� ������ ����� ���ڸ� ������ ���̸鼭 �˻縦 ���� ������ ����������.
		// ����) k�� 2���� ���� ����ؼ� max���� +1 ���� ������ �÷��ش�.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		long max = 0;
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		max++;
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			mid = (min + max) / 2;
			long count = 0;
			
			for(int i = 0; i < k; i++) {
				count += (arr[i] / mid);
			}
			if (count < n) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min -1);

	}

}
