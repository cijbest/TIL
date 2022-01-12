package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ST_17298 {
	
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [17298] ��ū��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		find();
		
	}
	
	// stack�� �ִ� ���� ���� ū ������ ���� ������ �ε����̰� ū ���� �߰����� �� �ش� �ε����� ū ���� �ʱ�ȭ
	/*
	 * ������ ������� �����鼭 
	 * ���� ���Ұ� ������ �� �� ���Ұ� ����Ű�� ���Һ��� ū ���
	 * �ش� ������ ������ �� ���� stack�� ���Ҹ� pop�ϸ鼭
	 * �ش� �ε����� ���� ���� ���ҷ� �ٲ��ش�. 
	 */
	public static void find() {
		Stack<Integer> stack = new Stack<Integer>();
		int n = arr.length;
		for(int index = 0; index < n; index++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
				arr[stack.pop()] = arr[index];
			}
			stack.push(index);
		}
		
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}

}
