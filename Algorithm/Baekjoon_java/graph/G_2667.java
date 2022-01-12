package graph;

import java.util.*;
import java.io.*;

public class G_2667 {
	static int n;
	static int[][] a;
	static boolean[][] check; // �湮����
	static int cnt = 0; // ������ ���� ��
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	static void dfs(int x, int y) {
		check[x][y] = true;
		cnt++;
		for(int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			if(dx >= 0 && dx < n && dy >= 0 && dy < n) {
				if(a[dx][dy] == 1 && check[dx][dy] == false) {
					check[dx][dy] = true;
					dfs(dx, dy);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// [2667] ������ȣ ���̱�
		// ���� �� : ó�� for������ dfs�� ���� �� ī����
		// ���� �� �� �� : dfs�� �� ������ ī����. �̶�, ī��Ʈ ������ ���������� ���� ���� ���� ������ų �� �ʱ�ȭ���־�� �Ѵ�.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			for(int j = 0; j < n; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> cArr = new ArrayList<Integer>(); // �� ���� ����
		check = new boolean[n][n];
		int dcnt = 0; // ���� ��
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 1 && check[i][j] == false) {
					dfs(i, j);
					cArr.add(cnt);
					cnt = 0;
					dcnt++;
				}
					
			}
		}
		
		Collections.sort(cArr);
		System.out.println(dcnt);
		for(int x : cArr) {
			System.out.println(x);
		}
						
	}

}
