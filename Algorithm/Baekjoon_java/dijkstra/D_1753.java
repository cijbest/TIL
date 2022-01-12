package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_1753 {
	
	public static final int INF = (int) 1e9;
	public static int v, e, k;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d;
	public static StringBuilder sb = new StringBuilder();
	
	public static class Node implements Comparable<Node>{
		int index, dist;
		
		public Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.index;
			int dist = node.dist;
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).dist;
				
				if(cost < d[graph.get(now).get(i).index]) {
					d[graph.get(now).get(i).index] = cost;
					pq.offer(new Node(graph.get(now).get(i).index, cost));
				}
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		// [1753] 최단경로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		d = new int[v+1];
		
		for(int i = 1; i <= v; i++) {
			d[i] = INF;
		}
		
		for(int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < e; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
		}
		
		dijkstra(k);
		
		for(int i = 1; i <= v; i++) {
			if(d[i] == INF) sb.append("INF").append("\n");
			else sb.append(d[i]).append("\n");
		}
		
		System.out.println(sb);

	}

}
