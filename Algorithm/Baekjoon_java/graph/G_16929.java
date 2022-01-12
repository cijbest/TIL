package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_16929 {
	static int N, M;
	static char[][] a;
	static boolean[][] check; // 방문 여부
	static int[][] dist; // 거리 기록
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static boolean dfs(int x, int y, int cnt, char color) {
		if(check[x][y]) {
			if(cnt - dist[x][y] >= 4) {
				return true;
			}
			else {
				return false;
			}
		}
		check[x][y] = true;
		dist[x][y] = cnt;
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if(a[nx][ny] == color) {
					if(dfs(nx, ny, cnt+1, color))
						return true;
				}
			}
		}	
		return false;
	}

	public static void main(String[] args) throws IOException {
		// [16929] Two Dots
		// cnt와 dist가 다른 이유 : cnt는 계속해서 방문 카운팅을 하고 dist 방뭄하지 않았을 때 cnt값을 기록하므로
		// 이미 방문했던 곳에 도착했을 때 각각의 값은 다르므로 서로의 차이를 가지고 사이클의 형성 유무를 알아낸다 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new char[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = bf.readLine();
			for(int j = 0; j < M; j++) {
				a[i][j] = (char) s.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j]) {
					dist = new int[N][M]; // 계속해서 dist 초기화
					boolean ok = dfs(i, j, 1, a[i][j]);
					if(ok) {
						System.out.println("Yes");
						System.exit(0); // 프로그램 종료
					}
				}
			}
		}
		System.out.println("No");
	}

}
