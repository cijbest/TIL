package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_1446 {
	
	public static final int INF = (int) 1e9;
	public static int N, D;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[10001];
	
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
	
	public static void dijsktra(int start) {
		if(start > D) {
			return;
		}
		
		if(d[start+1] > d[start] + 1) {
			d[start+1] = d[start] + 1;
		}
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			int cost = d[start] + graph.get(start).get(i).dist;
			
			if(cost < d[graph.get(start).get(i).index]) {
				d[graph.get(start).get(i).index] = cost;
			}
		}
		dijsktra(start+1);
	}

	public static void main(String[] args) throws IOException {
		// [1446] Áö¸§±æ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= 10000; i++) {
			d[i] = i;
			graph.add(new ArrayList<Node>());
		}
		
		Arrays.fill(d, INF);
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, dist));
		}
		
		dijsktra(0);
		
		System.out.println(d[D]);
		

	}

}
