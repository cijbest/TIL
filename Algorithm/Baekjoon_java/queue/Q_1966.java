package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1966 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1966] 프린터 큐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < testcase; t++) {
			LinkedList<int[]> q = new LinkedList<int[]>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken()); // 문서의 개수
			int m = Integer.parseInt(st.nextToken()); // 궁금한 문서가 몇 번째인지

			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < n; i++) {
				q.offer(new int[] {Integer.parseInt(st.nextToken()), i});
			}

			int cnt = 0;
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true;
				
				for(int i = 0; i < q.size(); i++) {
					// front가 최대값이 아닐 때
					if(front[0] < q.get(i)[0]) {
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				// 아직 최대값이 아니면
				if(!isMax)
					continue;
				
				// 최대값일 때
				cnt++;
				if(front[1] == m)
					sb.append(cnt).append("\n");
			}
		}
		System.out.println(sb);
		
		
		

	}

}
