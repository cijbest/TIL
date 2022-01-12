package topology_sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T_1766 {
	
	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] degree = new int[32001];
	
	public static void topology() {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				degree[graph.get(now).get(i)] -= 1;
				
				if(degree[graph.get(now).get(i)] == 0) {
					q.offer(graph.get(now).get(i));
				}
			}
            System.out.print(now + " ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		// [1766] ¹®Á¦Áý
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			degree[b] += 1;
		}
		
		topology();
	}

}
