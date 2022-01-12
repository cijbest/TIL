package stack;

import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input_len, i;
		Stack<Character> stack = new Stack<Character>();
		char t;
		String input = br.readLine();
		while (!input.equals(".")) {
			stack.clear();
			input_len = input.length();
			for (i = 0; i < input_len; i++) {
				t = input.charAt(i);
				if (t == '(' || t == '[') {
					stack.push(t);
				} else if (t == ')' || t == ']') {
					if (stack.isEmpty() || (t == ')' && stack.peek() != '(') || (t == ']' && stack.peek() != '[')) {
						stack.push(t);
						break;
					}
					stack.pop();
				}
				System.out.println(stack);
			}
			if (stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			input = br.readLine();
		}
	}
}
