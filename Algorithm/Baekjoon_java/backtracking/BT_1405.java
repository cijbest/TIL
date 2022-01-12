package backtracking;

import java.util.*;
import java.io.*;

public class BT_1405 {
	static int n;
	static double ans = 0;
	static int[] per;
	static boolean[][] check = new boolean[29][29];
	static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	static void go(int x, int y, int size, double res) {
		// n번 이동이 끝나면 계산한 확률을 더한다.
		if(size == n) {
			ans += res;
			return;
		}
		// 동서남북으로 이동
		for(int i = 0; i < 4; i++) {
			int nx = x+dir[i][0]; 
			int ny = y+dir[i][1];
			if(!check[nx][ny]) {
				check[nx][ny] = true;
				go(nx, ny, size+1, res*per[i]*0.01);
				check[nx][ny] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// [1405] 미친 로봇
		// 움직이는 방향마다 확률을 곱하고 n만큼 이동했을 때 단순경로라면 계속해서 더하면 찾는 확률이 나온다.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		per = new int[4];
		for(int i = 0; i < 4; i++) {
			// 동서남북
			per[i] = Integer.parseInt(st.nextToken());
		}
		
		check[14][14] = true;
		go(14, 14, 0, 1);
		System.out.println(ans);
	}

}
