package stack;

import java.util.*;
import java.io.*;

public class ST_9012_�Լ� {

	public static void main(String[] args) throws IOException {
		// [10773] ����
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
			if(str.charAt(index) == '(') { // '('�� ��
				stack.push(str.charAt(index));
			}
			else if(stack.isEmpty()){ // ������ ��� �ִµ� ')'�� �´ٴ� �� �տ� '('�� ���ٴ� ��
				return "NO";
			}else { // ')'�� ��
				stack.pop();
			}
		}
		if(stack.size() == 0) return "YES";
		else return "NO";
	}
}
