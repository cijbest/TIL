package graph;

import java.util.*;
import java.io.*;
// 다시해!!!!!!!!!!!
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class G_1261 {
	static int n, m;
	static int[][] a;
	static int[][] dist;
	static Queue<Point> q = new LinkedList<Point>();
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void bfs() {
		while(!q.isEmpty()) {
			Point e = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = e.x + dir[i][0];
				int ny = e.y + dir[i][1];
				if(0 <= nx && nx > n && 0 <= ny && ny < m) {
					if(dist[nx][ny] == -1) {
						System.out.println(nx + " " + ny);
						dist[nx][ny] = dist[e.x][e.y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// [1261] 알고스팟
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		dist = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}

		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			for(int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
				if(a[i][j] == 0) {
					if(i == n && j == m) continue;
					q.add(new Point(i, j));
					dist[i][j] = 0;
				}
			}
		}
		bfs();
		//System.out.println(dist[n-1][m-1] - 1);
	}

}
