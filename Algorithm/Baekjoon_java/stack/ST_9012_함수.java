package stack;

import java.util.*;
import java.io.*;

public class ST_9012_함수 {

	public static void main(String[] args) throws IOException {
		// [10773] 제로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			sb.append(check(br.readLine())+"\n");
		}
		System.out.println(sb);
		
	}
	
	public static String check(String str) {
		Stack<Character> stack = new Stack<>();
		for(int index = 0; index < str.length(); index++) {
			if(str.charAt(index) == '(') { // '('일 때
				stack.push(str.charAt(index));
			}
			else if(stack.isEmpty()){ // 스택이 비어 있는데 ')'가 온다는 건 앞에 '('가 없다는 것
				return "NO";
			}else { // ')'일 때
				stack.pop();
			}
		}
		if(stack.size() == 0) return "YES";
		else return "NO";
	}
}
