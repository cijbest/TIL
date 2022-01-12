package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UF_4195 {
	
	public static int[] parent;
	public static int[] cnt; // 연결된 사람 수 카운팅
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static int unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a != b) {
			parent[b] = a;
			cnt[a] += cnt[b];
		}
		
		return cnt[a];
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [4195] 친구 네트워크
		// find했을 때 결국은 부모 노드로 향하므로 부모 노드에 카운팅을 한다.
		// 배열 초기 크기가 F*2인 이유는 a, b가 전부 다 다른 사람일 경우를 생각해보면 된다.
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F*2];
			cnt = new int[F*2];

			// parent 초기화
			for(int i = 0; i < parent.length; i++) {
				parent[i] = i;
				cnt[i] = 1;
			}
			
			StringTokenizer st;
			int index = 0;
			HashMap<String, Integer> map = new HashMap<String, Integer>(); // 이름, 인덱스
			
			for(int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine(), " ");
				String n1 = st.nextToken();
				String n2 = st.nextToken();
				
				// map에 이름과 인덱스(parent 인덱스와 일치)를 봐관
				if(!map.containsKey(n1)) {
					map.put(n1, index++);
				}
				if(!map.containsKey(n2)) {
					map.put(n2, index++);
				}
				
				sb.append(unionParent(map.get(n1), map.get(n2))).append("\n");
				
			}
		}
		
		System.out.println(sb);

	}

}
