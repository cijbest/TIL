package graph;

import java.util.*;
import java.io.*;

class Node{
	int x, y, dist;
	Node(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
public class G_7526 {
	static boolean[][] check;
	static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1,-2}, {-2, -1}, {-1, -2}};
	static int sx, sy, ex, ey, l;
	
	
	static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(sx, sy, 0));
		check[sx][sy] = true;
		
		while(!q.isEmpty()) {
			Node e = q.poll();
			if (e.x == ex && e.y == ey) {
				return e.dist;
			}
			for(int i = 0; i < 8; i++) {
				int dx = e.x + dir[i][0];
				int dy = e.y + dir[i][1];
				if(dx >= 0 && dx < l && dy >= 0 && dy < l) {
					if(!check[dx][dy]) {
						check[dx][dy] = true;
						q.add(new Node(dx, dy, e.dist+1));
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [7526] 나이트의 이동
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for(int t = 0; t < T; t++) {
			l = Integer.parseInt(bf.readLine());
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine(), " ");
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			check = new boolean[l][l];
			sb.append(bfs() + "\n");
		}
		System.out.println(sb);
	}
}
