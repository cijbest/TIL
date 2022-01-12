package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Array_3052_스트림 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [3052] 나머지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[10];
		for(int i = 0 ; i < 10; i++) {
			num[i] = Integer.parseInt(br.readLine());
			num[i] = num[i] % 42;		
		}
		
		// stream 방법
		System.out.println(Arrays.stream(num).distinct().count());

		

	}

}
