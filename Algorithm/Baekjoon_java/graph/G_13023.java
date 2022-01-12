package graph;

import java.util.*;
import java.io.*;
public class G_13023 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	static int ans = 0;
	
	static void dfs(int x, int cnt) {
		// 5명만 친구이면 된다.
		if(cnt == 5) {
			ans = 1;
			return;
		}
		check[x] = true;
		for(int y : a[x]) {
			if(!check[y]) {
				dfs(y, cnt+1);
			}
		}
		check[x] = false;
	}
	public static void main(String[] args) throws IOException {
		// [13023] ABCDE
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		check = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			dfs(i, 1);
			if(ans == 1) break;
		}
		
		System.out.println(ans);

	}

}
