package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ST_4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [4949] �������� ����
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
			if(c == '(' || c == '[') { // '('�� ��
				stack.push(c);
			}
			else if(c == ')') { // ')' or ']'�� ��
				if(stack.isEmpty() || stack.peek() != '(') // ������ ��� �ִµ� ')'of ']'�� �� ��
					return "no";
				else
					stack.pop();
			}
			else if(c == ']') { // ')' or ']'�� ��
				if(stack.isEmpty() || stack.peek() != '[') // ������ ��� �ִµ� ')'of ']'�� �� ��
					return "no";
				else
					stack.pop();
			}
		}
		if(stack.isEmpty()) return "yes";
		else return "no";
	}

}
