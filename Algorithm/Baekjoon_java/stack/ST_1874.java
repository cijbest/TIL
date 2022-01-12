package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ST_1874 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1874] 스택 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(br.readLine());
		}
		
		solve(n, arr);

	}
	
	public static void solve(int n, int[] arr) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int num = 1;
		for(int index = 0; index < n; index++) {
			while(num <= arr[index]) { // 현재 위치한 수열의 값까지 스택에 저장
				stack.push(num++);
				sb.append("+\n");
			}
			if(stack.peek() == arr[index]) { // 스택 맨 위에 있는 값이 현재 수열의 값과 같으면 pop
				stack.pop();
				sb.append("-\n");
			}
			else { // 더 이상 수열을 만들 수 없는 경우
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}

}
