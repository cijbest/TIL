package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ST_10773 {

	public static void main(String[] args) throws IOException {
		// [10773] Á¦·Î
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		int[] stack = new int[k];
		int size = 0;
		for(int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) {
				stack[size] = n;
				size++;
			}else {
				stack[size-1] = 0;
				size--;
			}
		}
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += stack[i];
		}
		System.out.println(sum);
		
	}
}
