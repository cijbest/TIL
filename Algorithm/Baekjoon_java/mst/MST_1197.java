package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MST_1197 {
	
	static int v;
	static int e;
	static ArrayList<Edge> edges = new ArrayList<Edge>();
	static int[] parent;
	
	public static class Edge implements Comparable{
		int nodeA;
		int nodeB;
		int cost;
		
		public Edge(int nodeA, int nodeB, int cost) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Object o) {
			return this.cost - ((Edge) o).cost;
		}
		
	}
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1197] 최소 스패닝 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v+1];
		
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(nodeA, nodeB, cost));
		}
		
		Collections.sort(edges);
		
		for(int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		for(int i = 0; i < edges.size(); i++) {
			Edge e = edges.get(i);
			int nodeA = e.nodeA;
			int nodeB = e.nodeB;
			int cost = e.cost;
			
			if(findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA, nodeB);
				result += cost;
			}
		}
		
		System.out.println(result);

	}

}
