package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_13913 {
	static int n, k;
	static int[] time;
	static int max = 1000001;
	static int[] from; // 이전 위치 저장
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			int x = q.poll();
			// k 지점에 오면 반복문 중지
			if(x == k) break;
			// x-1로 이동
			if(x-1 >= 0 && time[x-1] == 0) {
				time[x-1] = time[x] + 1;
				q.add(x-1);
				from[x-1] = x;
			}
			// x+1로 이동
			if(x+1 < max && time[x+1] == 0) {
				time[x+1] = time[x] + 1;
				q.add(x+1);
				from[x+1] = x;
			}
			//2*x로 이동
			if(2*x < max && time[2*x] == 0) {
				time[2*x] = time[x] + 1;
				q.add(2*x);
				from[2*x] = x;
			}
					
		}
	}
	static void print(int start , int end) {
		if(start != end) {
			print(start, from[end]);
		}
		System.out.print(end + " ");
	}

	public static void main(String[] args) throws IOException {
		// [13913] 숨바꼭질4
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = new int[max];
		from = new int[max];
		// 최소시간 계산 및 이전 위치 저장
		bfs(n);
		System.out.println(time[k]);
		// 지나온 위치 출력
		print(n, k);
		
		/* print with stack = 스택으로 출력하기
        Stack<Integer> ans = new Stack<>();
        for (int i=m; i!=n; i=from[i]) {
            ans.push(i);
        }
        ans.push(n);
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
        */

	}

}
