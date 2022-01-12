package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_11866_링크드리스트_인덱스 {

	public static void main(String[] args) throws IOException {
		// [11866] 요세푸스 문제 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		// 특정 k 간격으로 있는 수들을 찾을 땐, (index + (k-1)) % list사이즈
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int index = 0;
		while(n > 1) {
			index = (index + (k-1)) % n;
			sb.append(list.remove(index)).append(", ");
			n--;
		}
		sb.append(list.remove()).append(">");
		System.out.println(sb);

	}

}
