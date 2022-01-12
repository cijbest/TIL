package stack;

import java.util.*;
import java.io.*;

public class ST_9012 {

	public static void main(String[] args) throws IOException {
		// [10773] 제로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int index = 0; index < str.length(); index++) {
				if(str.charAt(index) == '(') {
					stack.push(str.charAt(index));
				}
				if(str.charAt(index) == ')'){
					if(stack.isEmpty()) { // 스택이 비어 있는데 ')'가 온다는 건 앞에 '('가 없다는 것
						stack.push(str.charAt(index));
						break;
					}else {
						stack.pop();
					}
				}
				//System.out.println(">>> "+stack);
			}
			if(stack.size() == 0) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
}
