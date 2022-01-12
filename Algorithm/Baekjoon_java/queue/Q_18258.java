package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [18258] ť2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] queue = new int[N];
		int front = 0;
		int back = -1;
		
		StringBuilder sb = new StringBuilder();
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				back++;
				queue[back] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if(back-front == -1) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue[front]).append("\n");
					front++;
				}
				break;
			case "size":
				sb.append(back-front+1).append("\n");
				break;
			case "empty":
				if(back-front == -1)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if(back-front == -1)
					sb.append(-1).append("\n");
				else
					sb.append(queue[front]).append("\n");
				break;
			case "back":
				if(back-front == -1)
					sb.append(-1).append("\n");
				else
					sb.append(queue[back]).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
