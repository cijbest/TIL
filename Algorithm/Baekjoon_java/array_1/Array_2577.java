package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2562] ÃÖ´ñ°ª
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
//		for(int i = 0 ; i < 3; i++) {
//			num *= Integer.parseInt(br.readLine());
//		}

		int[] cnt = new int[10];
		String sNum = String.valueOf(num);
		for(int i = 0 ; i < sNum.length(); i++) {
			cnt[sNum.charAt(i) -'0']++;
		}
		
		for(int c : cnt) {
			System.out.println(c);
		}

	}

}
