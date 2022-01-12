package graph;

import java.util.*;
import java.io.*;

public class G_13549 {
	static int n, k;
	static int max = 100001;
	static int[] dist = new int[max];
	static int ans = 0;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		dist[start] = 0;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x == k) {
				break;
			}
			// 주의! 2*x일 때 시간이 0초 요소되므로 다른 연산보다 앞에 위치해야 한다.
			if(2*x < max && dist[2*x] == -1) {
				q.add(2*x);
				dist[2*x] = dist[x];
			}
			if(x-1 >= 0 && dist[x-1] == -1) {
				q.add(x-1);
				dist[x-1] = dist[x] + 1;
			}
			if(x+1 < max && dist[x+1] == -1) {
				q.add(x+1);
				dist[x+1] = dist[x] + 1;
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		// [13579] 숨바꼭질3
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Arrays.fill(dist, -1);
		bfs(n);
		System.out.println(dist[k]);

	}

}
