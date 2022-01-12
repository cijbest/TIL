package binarySearch;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BS_10816_HashMap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10816] 숫자 카드2
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
  		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");

		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(key, 0)).append(" ");
		}
		System.out.println(sb);

	}

}
