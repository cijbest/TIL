package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fx_1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1065] ÇÑ¼ö
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(!check(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean check(int n) {
		if(n <= 99) return false;
		char[] num = String.valueOf(n).toCharArray();
		int diff = num[1]-num[0];
		for(int i = 2; i < num.length; i++) {
			if(diff != (num[i]- num[i-1])) {
				return true;
			}
		}
		return false;
	}

}
