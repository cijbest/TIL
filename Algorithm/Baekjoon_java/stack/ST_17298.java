package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ST_17298 {
	
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [17298] 오큰수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		find();
		
	}
	
	// stack에 넣는 것은 가장 큰 수보다 작은 값들의 인덱스이고 큰 수를 발견했을 때 해당 인덱스를 큰 수로 초기화
	/*
	 * 스택이 비어있지 않으면서 
	 * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
	 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
	 * 해당 인덱스의 값을 현재 원소로 바꿔준다. 
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
