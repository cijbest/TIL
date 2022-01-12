package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_2 {

	public static void main(String[] args) throws IOException {
		
		// StringTokenizer : 문자열을 토큰으로 잘라야 할 때
		// 1 2 3 4 5 => 15
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		int sum = 0;
		while(st.hasMoreTokens()) {
			sum += Integer.valueOf(st.nextToken());
		}
		System.out.println(sum);
	}

}
