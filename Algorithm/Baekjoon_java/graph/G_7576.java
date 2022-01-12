package graph;

import java.util.*;
import java.io.*;

class Node3{
	int x, y;
	Node3(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class G_7576 {
	static int n, m;
	static int[][] a;
	static int[][] check; // 방문여부 및 거리저장
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Queue<Node3> q = new LinkedList<Node3>();;
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node3 e = q.poll();
			for(int i = 0; i < 4; i++) {
				int dx = e.x + dir[i][0];
				int dy = e.y + dir[i][1];
				if(dx >= 0 && dx < n && dy >= 0 && dy < m) {
					if(a[dx][dy] == 0 && check[dx][dy] == 0) {
						a[dx][dy] = 1;
						check[dx][dy] = check[e.x][e.y] + 1;
						q.add(new Node3(dx, dy));
					}
				}
			}
		}
	}
	static int isAllRaped() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] == 0) {
					return -1;
				}
				if(check[i][j] > 0) {
					cnt = Math.max(cnt, check[i][j]);
				}
			}
		}
		return cnt - 1;
	}
	
	public static void main(String[] args) throws IOException {
		// [7576] 토마토
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		
		check = new int[n][m];
		

		// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 없음
		// 이미 다 익음 : 0, 다 못 익어 : -1
		boolean allRaped = true; // 토마토가 이미 다 익었는지 확인
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] == 1) {
					q.add(new Node3(i, j));
					check[i][j] = 1;
					
				}else if(a[i][j] == 0){
					allRaped = false;
				}
			}
		}
		// 이미 다 익어 있는지 확인
		if(allRaped) {
			System.out.println(0);
		}
		else {
			bfs();
			
			// 안 익은 토마토가 있을 때
			System.out.println(isAllRaped());
		}
	}

}
