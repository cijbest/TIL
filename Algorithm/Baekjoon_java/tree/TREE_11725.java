package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TREE_11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11725] 트리의 부모 찾기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		// 각각 연결된 정점 보관
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		boolean[] check = new boolean[n+1]; // 방문 했는지 안 했는지 확인
		int[] parent = new int[n+1]; // 부모 노드 명시
		Queue<Integer> q = new LinkedList<Integer>(); // 방문하지 않은 노드 삽입 후 부모 지정
		// 루트 초기 설정
		q.add(1);
		check[1] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int y : arr[x]) {
				if(check[y] == false) {
					check[y] = true;
					parent[y] = x;
					q.add(y);
				}
			}
		}
		
		for(int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
	}

}
