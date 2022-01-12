package graph;

import java.util.*;
import java.io.*;

public class G_1694 {
	static int n;
	static ArrayList<Integer>[] a;
	static int[] check; // ����Ŭ�� ���� ���� => 1 : ����Ŭ X, 2 : ����Ŭ O
	static Queue<Integer> q = new LinkedList<Integer>();;
	static int[] dist;
	
	static int dfs(int x, int p) {
		// ���ϰ� => -2 : ����Ŭ O, ��ȸ�� ���� X / -1 : ����Ŭ X / 0~n : ����Ŭ O, ������ ����
		// ����Ŭ ã���� �� ������ x ����, �̹� ������ ������ �ٽ� �°Ŵϱ�
		if (check[x] == 1) return x; 
		
		check[x] = 1; // �湮 ǥ��
		for(int y : a[x]) {
			// ���� ��尡 ���� ����� �ǳʶٱ�
			if(y == p) continue;
			// ���� ����� ���� �˾ƺ���
			int res = dfs(y, x); 
			// ���� ����� ���°� -2�̸� ����Ŭ�� ������ ������ �� �Ǿ����Ƿ� -2����
			if(res == -2) return -2;
			
			// ���ϰ��� �������� ��
			if(res >= 0) {
				check[x] = 2; // �������� ���� �޾����Ƿ� check���� 2�� ����
				if(x == res) return -2; // ������������ ���ƿ����Ƿ� �������� �������� �ʰ� -2 ����
				else return res; // ���������� �ƴ����� ��ȸ�� �ȿ� ���� �� ���ϰ� �ٽ� ����
			}
		}
		return -1; // ����Ŭ�� ���� ��
	}

	static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int y : a[x]) {
				if(dist[y] == -1) { // �湮���� ���� ����
					q.add(y);
					dist[y] = dist[x] + 1;
				}
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1694] ���� ����ö 2ȣ��
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new ArrayList[n+1];
		check = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		
		// �� ������ Ž���Ͽ� ��ȸ���� � ���� �Ǻ�
		dfs(1, 0);
		
		// ��ȸ�����κ��� ������ �Ÿ� ���ϱ�
		dist = new int[n+1];
		for(int i = 1; i <= n; i++) {
			if(check[i] == 2) {
				dist[i] = 0;
				q.add(i);
			}else {
				dist[i] = -1; // ť�� ���� �ʾҴ� = �湮���� ���� ���� ǥ��
			}
		}
		bfs();
		
		// ���
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(dist[i] + " ");
		}
		System.out.println(sb);

	}

}
