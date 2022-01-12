package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UF_4195 {
	
	public static int[] parent;
	public static int[] cnt; // ����� ��� �� ī����
	
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
		// [4195] ģ�� ��Ʈ��ũ
		// find���� �� �ᱹ�� �θ� ���� ���ϹǷ� �θ� ��忡 ī������ �Ѵ�.
		// �迭 �ʱ� ũ�Ⱑ F*2�� ������ a, b�� ���� �� �ٸ� ����� ��츦 �����غ��� �ȴ�.
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F*2];
			cnt = new int[F*2];

			// parent �ʱ�ȭ
			for(int i = 0; i < parent.length; i++) {
				parent[i] = i;
				cnt[i] = 1;
			}
			
			StringTokenizer st;
			int index = 0;
			HashMap<String, Integer> map = new HashMap<String, Integer>(); // �̸�, �ε���
			
			for(int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine(), " ");
				String n1 = st.nextToken();
				String n2 = st.nextToken();
				
				// map�� �̸��� �ε���(parent �ε����� ��ġ)�� ����
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
