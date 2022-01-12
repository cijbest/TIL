package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UF_1717 {
	
	public static int n, m;
	public static int[] parent;
	
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

	public static void main(String[] args) throws IOException {
		// [1717] 집합의 표현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 합집합
			if(cmd == 0) {
				unionParent(a, b);
			}
			// 같은 집합인지 확인
			else {
				if(findParent(a) != findParent(b)) {
					sb.append("NO").append("\n");
				}else {
					sb.append("YES").append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
		for(int i = 1; i <= n; i++) {
			System.out.print(parent[i] + " ");
		}
	}

}
