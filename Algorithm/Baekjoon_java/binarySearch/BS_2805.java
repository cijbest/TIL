package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS_2805 {

	public static void main(String[] args) throws IOException {
		// [2805] 나무 자르기
		// 랜선 자르기 문제와 동일한 풀이법 적용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		long max = 0;
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
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
			
			for(int i = 0; i < n; i++) {
				long rem = arr[i] - mid;
				if(rem > 0)
					count += rem;
			}
			if (count < m) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min -1);

	}

}
