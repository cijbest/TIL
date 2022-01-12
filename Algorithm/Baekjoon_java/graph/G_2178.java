package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2{
	int x, y;
	Node2(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class G_2178 {
	static int n, m;
	static int[][] a;
	static int[][] check; // 방문여부 및 거리저장
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Queue<Node2> q;
	
	static void bfs(int x, int y) {
		q.add(new Node2(x, y));
		check[x][y] = 1;
		
		while(!q.isEmpty()) {
			Node2 e = q.poll();
			for(int i = 0; i < 4; i++) {
				int dx = e.x + dir[i][0];
				int dy = e.y + dir[i][1];
				if(dx >= 0 && dx < n && dy >= 0 && dy < m) {
					if(a[dx][dy] == 1 && check[dx][dy] == 0) {
						check[dx][dy] = check[e.x][e.y] + 1;
						q.add(new Node2(dx, dy));
						
					}
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// [2178] 미로 탐색
		// 최단거리 문제 => BFS
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			for(int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		check = new int[n][m];
		q = new LinkedList<Node2>();
		bfs(0, 0);
		System.out.println(check[n-1][m-1]);

	}

}
