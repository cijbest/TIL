package binarySearch;

import java.util.*;
import java.io.*;
public class BS_1654 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1654] 랜선 자르기
		// UpperBound 이용해서 최대값을 구한다.
		// min, max로 범위를 만들고 숫자를 반으로 줄이면서 검사를 통해 범위를 좁혀나간다.
		// 주의) k가 2개일 때를 고려해서 max값을 +1 해줘 범위를 늘려준다.
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
