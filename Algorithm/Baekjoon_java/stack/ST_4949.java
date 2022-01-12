package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ST_4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [4949] 균형잡힌 세상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("."))
				break;
			sb.append(check(s)+"\n");
		}
		System.out.println(sb);
	}
	
	public static String check(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(char c: str.toCharArray()){
			if(c == '(' || c == '[') { // '('일 때
				stack.push(c);
			}
			else if(c == ')') { // ')' or ']'일 때
				if(stack.isEmpty() || stack.peek() != '(') // 스택이 비어 있는데 ')'of ']'가 올 때
					return "no";
				else
					stack.pop();
			}
			else if(c == ']') { // ')' or ']'일 때
				if(stack.isEmpty() || stack.peek() != '[') // 스택이 비어 있는데 ')'of ']'가 올 때
					return "no";
				else
					stack.pop();
			}
		}
		if(stack.isEmpty()) return "yes";
		else return "no";
	}

}
