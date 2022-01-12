package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Array_10818_스트림 {

	public static void main(String[] args) throws IOException {
		// [10818] 최대, 최소
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int[] data = new int[n];

		for(int index = 0; index < n; index++) {
			data[index] = Integer.parseInt(st.nextToken());
		}
		
//		sb.append(Arrays.stream(data).boxed().min(Integer::compare).get() + " ");
//		sb.append(Arrays.stream(data).boxed().max(Integer::compare).get());
		
		sb.append(Arrays.stream(data).min().getAsInt() + " ");
		sb.append(Arrays.stream(data).max().getAsInt());
		
		System.out.println(sb);
		
		
		
		

	}

}
