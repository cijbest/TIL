package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fx_4673 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [15596] 정수 N개의 합
		int[] arr = new int[10001];
		int n = 1;
		for(int i = 0; i < 10000; i++) {
			int num = d(i);
			if(num <= 10000)
				arr[num] = 1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == 0)
				sb.append(i + "\n");
		}
		System.out.println(sb);
	}
	
	public static int d(int n) {
		int ans = n;
		while(n != 0) {
			ans += n % 10;
			n /= 10;
		}
		return ans;
	}
	

}
