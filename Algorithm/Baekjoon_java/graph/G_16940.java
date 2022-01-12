package graph;

import java.util.*;
import java.io.*;
// 다시해!!!!!!!!!!!!!!!!!!!!!
public class G_16940 {
	static int n;
	static ArrayList<Integer>[] a;
	static boolean[] check;
	static int[] order;
	static int[] parent;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		check[1] = true;
		q.add(1);
		
		while(!q.isEmpty()){
			int x = q.poll();
			for(int y : a[x]) {
				if(!check[y]) {
					check[y] = true;
					q.add(y);
					parent[y] = parent[x] + 1;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [16940] BFS 스페셜 저지
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new ArrayList[n+1];
		check = new boolean[n+1];
		parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		
		order = new int[n+1];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
//		for(int i = 1; i <= n; i++) {
//			System.out.print(parent[i] + " ");
//		}
		int ans = 1;
		int tmp = 0;
		for(int i = 1; i <= n; i++) {
			if(tmp <= parent[order[i]]) {
				tmp = parent[order[i]];
			}
			else {
				ans = 0;
				break;
			}				
		}
		System.out.println(ans);
		
	}

}
