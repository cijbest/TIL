package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2562] ÃÖ´ñ°ª
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int index = 0;
		int max = arr[0];
		for(int i = 0 ; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				index = i;
				max = arr[i];
			}
		}
		System.out.print(max + "\n" + (index+1));
		

	}

}
