package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Array_10818 {

	public static void main(String[] args) throws IOException {
		// [10818] 최대, 최소
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int[] data = new int[n];

		int max = -1000001;
		int min = 1000001;
		for(int index = 0; index < n; index++) {
			data[index] = Integer.parseInt(st.nextToken());
			if(data[index] > max)
				max = data[index];
			if(data[index] < min)
				min = data[index];
		}
		System.out.println(min + " " + max);
		
		// 정렬 - 시간 더 걸림
//		for(int index = 0; index < n; index++) {
//			data[index] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(data);
//		System.out.println(data[0] + " " + data[n-1]);
		
		

	}

}
