package tree;

import java.io.*;
import java.util.*;

class Node{
	int left, right;
	public int order, depth;
	Node(int left, int right){
		this.left = left;
		this.right = right;
	}
	
}
public class TREE_2250 {
	static Node[] a = new Node[10001]; // 노드의 왼쪽 자식, 오른쪽 자식, 인오더 순번, 깊이 정보를 저장
	static int[] left = new int[10001]; // 같은 깊이에 있는 노드들 중에서 가장 왼쪽에 있는 노드의 순서값을 저장
	static int[] right = new int[10001]; // 같은 깊이에 있는 노드들 중에서 가장 오른쪽에 있는 노드의 순서값을 저장
	public static int[] cnt = new int[10001]; // 루트 노드를 찾기 위해 자식의 수를 카운트
	static int order = 0; // 인오더 순서 부여
	
	static void inorder(int node, int depth) {
		if(node == -1) return;
		inorder(a[node].left, depth + 1);
		a[node].order = ++order;
		a[node].depth = depth;
		inorder(a[node].right, depth + 1);
	}
	

	public static void main(String[] args) throws IOException {
		// [2250] 트리의 높이와 너비
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		// 노드 정보 저장
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			// 노드의 자식노드 저장
			a[x] = new Node(y, z);
			
			// 루트노드가 1이 아닐 수도 있기 때문에 자식 노드인 것들을 표시하여 cnt의 값이 0인 인덱스가 루트노드라는 걸 알 수 있음
			if(y != -1) cnt[y] += 1;
			if(z != -1) cnt[z] += 1;
		}

		// 루트노드 찾기
		int root = 0;
		for(int i = 1 ; i <= n; i++) {
			if(cnt[i] == 0) {
				root = i;
			}
		}
		
		// 인오더로 노드의 순서와 깊이 정보 저장, 초기 깊이는 1
		inorder(root, 1);
		
		// 최대 깊이 구하고, 각 깊이별로 가장 왼쪽에 있는 인오더 순서와 가장 오른쪽에 있는 인오더 순서를 저장
		int maxdepth = 0;
		for(int i = 1; i <= n; i++) {
			int depth = a[i].depth;
			int order = a[i].order;
			// 가장 왼쪽 노드 순서, 가장 오른쪽 노드 순서 구하기
			if(left[depth] == 0) {
				left[depth] = order;
			}
			else {
				left[depth] = Math.min(left[depth], order);
			}
			right[depth] = Math.max(right[depth], order);
			// 최대 깊이 구하기
			maxdepth = Math.max(maxdepth, depth);
		}
		
		// 가장 큰 너비값과 너비가 가장 긴 레벨 구하기
		int ans = 0;
		int ans_level = 0;
		for(int i = 1; i <= maxdepth; i++) {
			if(ans < right[i] - left[i] + 1) {
				ans = right[i] - left[i] + 1;
				ans_level = i;
			}
		}
		System.out.println(ans_level + " " + ans);

	}

}
