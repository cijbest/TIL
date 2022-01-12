package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Array_3052_HashSet {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [3052] ³ª¸ÓÁö
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0 ; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			set.add(num % 42);		
		}
		
		System.out.println(set.size());
	}

}
