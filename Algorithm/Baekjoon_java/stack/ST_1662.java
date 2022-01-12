package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ST_1662 {

	public static void main(String[] args) throws IOException {
		// [1662] æ–√‡
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		Stack<Character> stk = new Stack<Character>();
		int i = 0;
		int cnt = 0;
		while(true) {
			char c = s.charAt(i);
			if(c == ')') {
				
			}
			else if(c == '(') {
				stk.add(c);
				cnt++;
			}
			else {
				stk.add(c);
				cnt++;
			}
			i++;
		}

	}

}
