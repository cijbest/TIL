package floyd_warchall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FW_1956 {
	
	static final int INF = (int) 1e9;
	static int v;
	static int e;
	static int[][] d;
	
	public static void main(String[] args) throws IOException {
		// [1956] ¿îµ¿
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = new int[v+1][v+1];
		
		for(int i = 1; i <= v; i++) {
			Arrays.fill(d[i], INF);
		}
		
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++) {
				if(i == j) d[i][j] = 0;
			}
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			d[a][b] = dist;
		}
		
		for(int k = 1; k <= v; k++) {
			for(int i = 1; i <= v; i++) {
				for(int j = 1; j <= v; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		
		int result = INF;
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++) {
				if(d[i][j] != INF && d[j][i] != INF) {
					if(i == j) continue;
					result = Math.min(result, d[i][j] + d[j][i]);
				}
			}
		}
		System.out.println((result == INF)? -1 : result);
	}

}
