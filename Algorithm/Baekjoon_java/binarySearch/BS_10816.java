package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BS_10816 {
	public static int[] a;
	public static int upperB(int key) {
		int lo = 0;
		int hi = a.length;
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if (key < a[mid])
				hi = mid;
			else
				lo = mid + 1;
		}
		return lo;
	}
	public static int lowerB(int key) {
		int lo = 0;
		int hi = a.length;
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if (key <= a[mid])
				hi = mid;
			else
				lo = mid + 1;
		}
		return lo;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10816] 숫자 카드2
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		a = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");

		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperB(key) - lowerB(key)).append(" ");
		}
		System.out.println(sb);

	}

}
