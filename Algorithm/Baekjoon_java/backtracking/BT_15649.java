package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BT_15649 {
	static int N, M;
	static int[] arr; // 숫자 저장 용도
	static boolean[] visited;
	
	static void go(int depth) {
		if(depth == M) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				go(depth+1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// [15649] N과 M(1)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N];
		go(0);

	}

}
