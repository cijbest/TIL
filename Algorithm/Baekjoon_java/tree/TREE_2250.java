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
	static Node[] a = new Node[10001]; // ����� ���� �ڽ�, ������ �ڽ�, �ο��� ����, ���� ������ ����
	static int[] left = new int[10001]; // ���� ���̿� �ִ� ���� �߿��� ���� ���ʿ� �ִ� ����� �������� ����
	static int[] right = new int[10001]; // ���� ���̿� �ִ� ���� �߿��� ���� �����ʿ� �ִ� ����� �������� ����
	public static int[] cnt = new int[10001]; // ��Ʈ ��带 ã�� ���� �ڽ��� ���� ī��Ʈ
	static int order = 0; // �ο��� ���� �ο�
	
	static void inorder(int node, int depth) {
		if(node == -1) return;
		inorder(a[node].left, depth + 1);
		a[node].order = ++order;
		a[node].depth = depth;
		inorder(a[node].right, depth + 1);
	}
	

	public static void main(String[] args) throws IOException {
		// [2250] Ʈ���� ���̿� �ʺ�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		// ��� ���� ����
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			// ����� �ڽĳ�� ����
			a[x] = new Node(y, z);
			
			// ��Ʈ��尡 1�� �ƴ� ���� �ֱ� ������ �ڽ� ����� �͵��� ǥ���Ͽ� cnt�� ���� 0�� �ε����� ��Ʈ����� �� �� �� ����
			if(y != -1) cnt[y] += 1;
			if(z != -1) cnt[z] += 1;
		}

		// ��Ʈ��� ã��
		int root = 0;
		for(int i = 1 ; i <= n; i++) {
			if(cnt[i] == 0) {
				root = i;
			}
		}
		
		// �ο����� ����� ������ ���� ���� ����, �ʱ� ���̴� 1
		inorder(root, 1);
		
		// �ִ� ���� ���ϰ�, �� ���̺��� ���� ���ʿ� �ִ� �ο��� ������ ���� �����ʿ� �ִ� �ο��� ������ ����
		int maxdepth = 0;
		for(int i = 1; i <= n; i++) {
			int depth = a[i].depth;
			int order = a[i].order;
			// ���� ���� ��� ����, ���� ������ ��� ���� ���ϱ�
			if(left[depth] == 0) {
				left[depth] = order;
			}
			else {
				left[depth] = Math.min(left[depth], order);
			}
			right[depth] = Math.max(right[depth], order);
			// �ִ� ���� ���ϱ�
			maxdepth = Math.max(maxdepth, depth);
		}
		
		// ���� ū �ʺ񰪰� �ʺ� ���� �� ���� ���ϱ�
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
