package graph;

import java.util.*;
import java.io.*;

public class G_1697 {
	static int n, k;
	static int[] time;
	static int max = 1000001;
	
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
			}
			// x+1로 이동
			if(x+1 < max && time[x+1] == 0) {
				time[x+1] = time[x] + 1;
				q.add(x+1);
			}
			//2*x로 이동
			if(2*x < max && time[2*x] == 0) {
				time[2*x] = time[x] + 1;
				q.add(2*x);
			}
					
		}
	}

	public static void main(String[] args) throws IOException {
		// [1697] 숨바꼭질
		// 세 가지 조건 동시에 확인해나가야 하므로 bfs
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = new int[max];
		bfs(n);
		System.out.println(time[k]);
	}

}
