package graph;

import java.io.*;
import java.util.*;

public class G_1707 {
	static int[] group;
	static ArrayList<Integer>[] a;
	
	static void dfs(int x, int c) {
		group[x] = c;
		for(int y : a[x]) {
			if(group[y] == 0) {
				dfs(y, 3-c);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1707] �̺� �׷���
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			a = new ArrayList[V+1];
			for(int i = 1; i < V+1; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				a[u].add(v);
				a[v].add(u);
			}
			group = new int[V+1];
			// � ��忡���� �� ���� �� �� ���� �����Ƿ� ��ü ��� Ȯ��
			for(int i = 1; i <= V; i++) {
				if(group[i] == 0) {
					dfs(i, 1);
				}
			}
			
			// ���� ����� ������ �ٸ� �׷��̾�� �̺� �׷����� ����
			boolean ok = true;
			for(int i = 1; i <= V; i++) {
				for(int j : a[i]) {
					if(group[i] == group[j]) {
						ok = false;
					}
				}
			}
			if(ok) {
				sb.append("YES" + "\n");
			}
			else {
				sb.append("NO" + "\n");
			}
		
		}
		System.out.println(sb);
	}

}
