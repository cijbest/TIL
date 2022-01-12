package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ST_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [10828] Ω∫≈√
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			if(order.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(order.equals("pop")) {
				if(stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
			}
			else if(order.equals("size")) {
				System.out.println(stack.size());
			}
			else if(order.equals("empty")) {
				if(stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else {
				if(stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.lastElement());
			}
			
		}
	}

}
