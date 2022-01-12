package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TREE_11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11725] Ʈ���� �θ� ã��
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		// ���� ����� ���� ����
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		boolean[] check = new boolean[n+1]; // �湮 �ߴ��� �� �ߴ��� Ȯ��
		int[] parent = new int[n+1]; // �θ� ��� ���
		Queue<Integer> q = new LinkedList<Integer>(); // �湮���� ���� ��� ���� �� �θ� ����
		// ��Ʈ �ʱ� ����
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
