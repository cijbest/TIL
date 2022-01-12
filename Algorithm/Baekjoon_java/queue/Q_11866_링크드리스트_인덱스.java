package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_11866_��ũ�帮��Ʈ_�ε��� {

	public static void main(String[] args) throws IOException {
		// [11866] �似Ǫ�� ���� 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		// Ư�� k �������� �ִ� ������ ã�� ��, (index + (k-1)) % list������
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
