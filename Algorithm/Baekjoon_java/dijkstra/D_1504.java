package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_1504 {
	
	public static final int INF = (int) 1e9;
	public static int n, e, v1, v2;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d;
	
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
		// [1504] 특정한 최단 경로
		// long 타입의 중요성...★
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = new int[n+1];
		
		Arrays.fill(d, INF);
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		dijkstra(1);
		long route1 = d[v1];
		long route2 = d[v2];
		
		Arrays.fill(d, INF);
		
		dijkstra(v1);
		route1 += d[v2];
		route2 += d[n];
		
		Arrays.fill(d, INF);
		
		dijkstra(v2);
		route1 += d[n];
		route2 += d[v1];
		
		long answer = Math.min(route1, route2);
		System.out.println(answer >= INF ? -1 : answer);
		

	}

}
