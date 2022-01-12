package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ST_9012_함수_포인터 {

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
		int top = -1;
		// for(char c: str.toCharArray()){
		for(int index = 0; index < str.length(); index++) {
			if(str.charAt(index) == '(') { // '('일 때
				top++;
			}
			else if(top < 0){ // 스택이 비어 있는데 ')'가 온다는 건 앞에 '('가 없다는 것
				return "NO";
			}else { // ')'일 때
				top--;
			}
		}
		if(top == -1) return "YES";
		else return "NO";
	}
}
