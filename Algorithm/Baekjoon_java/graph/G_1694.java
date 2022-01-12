package graph;

import java.util.*;
import java.io.*;

public class G_1694 {
	static int n;
	static ArrayList<Integer>[] a;
	static int[] check; // 사이클에 포함 여부 => 1 : 사이클 X, 2 : 사이클 O
	static Queue<Integer> q = new LinkedList<Integer>();;
	static int[] dist;
	
	static int dfs(int x, int p) {
		// 리턴값 => -2 : 사이클 O, 순회선 포함 X / -1 : 사이클 X / 0~n : 사이클 O, 시작점 리턴
		// 사이클 찾았을 때 시작점 x 리턴, 이미 지났던 지점을 다시 온거니까
		if (check[x] == 1) return x; 
		
		check[x] = 1; // 방문 표시
		for(int y : a[x]) {
			// 다음 노드가 이전 노드라면 건너뛰기
			if(y == p) continue;
			// 다음 노드의 상태 알아보기
			int res = dfs(y, x); 
			// 다음 노드의 상태가 -2이면 사이클은 있지만 포함이 안 되었으므로 -2리턴
			if(res == -2) return -2;
			
			// 리턴값이 시작점일 때
			if(res >= 0) {
				check[x] = 2; // 시작점을 리턴 받았으므로 check값을 2로 변경
				if(x == res) return -2; // 시작지점으로 돌아왔으므로 시작점을 리턴하지 않고 -2 리턴
				else return res; // 시작지점은 아니지만 순회선 안에 있을 때 리턴값 다시 리턴
			}
		}
		return -1; // 사이클이 없을 때
	}

	static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int y : a[x]) {
				if(dist[y] == -1) { // 방문하지 않은 지점
					q.add(y);
					dist[y] = dist[x] + 1;
				}
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1694] 서울 지하철 2호선
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new ArrayList[n+1];
		check = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		
		// 각 정점을 탐색하여 순회선이 어떤 건지 판별
		dfs(1, 0);
		
		// 순회선으로부터 떨어진 거리 구하기
		dist = new int[n+1];
		for(int i = 1; i <= n; i++) {
			if(check[i] == 2) {
				dist[i] = 0;
				q.add(i);
			}else {
				dist[i] = -1; // 큐에 넣지 않았다 = 방문하지 않은 지점 표시
			}
		}
		bfs();
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(dist[i] + " ");
		}
		System.out.println(sb);

	}

}
