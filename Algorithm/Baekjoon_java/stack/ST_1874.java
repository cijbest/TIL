package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ST_1874 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1874] ���� ����
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
			while(num <= arr[index]) { // ���� ��ġ�� ������ ������ ���ÿ� ����
				stack.push(num++);
				sb.append("+\n");
			}
			if(stack.peek() == arr[index]) { // ���� �� ���� �ִ� ���� ���� ������ ���� ������ pop
				stack.pop();
				sb.append("-\n");
			}
			else { // �� �̻� ������ ���� �� ���� ���
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}

}
