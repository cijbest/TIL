package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_4963 {
	static int w, h;
	static int[][] a;
	static boolean[][] check; // 방문여부
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
	static void dfs(int x, int y) {
		check[x][y] = true;
		for(int i = 0; i < 8; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			if(dx >= 0 && dx < h && dy >= 0 && dy < w) {
				if(a[dx][dy] == 1 && check[dx][dy] == false) {
					check[dx][dy] = true;
					dfs(dx, dy);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// [4963] 섬의 개수
		// 대각선 이동도 포함한다.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			// 반복문 끝
			if(w == 0 && h == 0)
				break;
			
			a = new int[h][w];
			check = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j = 0; j < w; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(a[i][j] == 1 && check[i][j] == false) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}
