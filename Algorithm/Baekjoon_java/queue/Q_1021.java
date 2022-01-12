package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q_1021 {

	public static void main(String[] args) throws IOException {
		// [1021] ȸ���ϴ� ť
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // ť�� ũ��
		int M = Integer.parseInt(st.nextToken()); // �̾Ƴ������ϴ� ���� ����
		LinkedList<Integer> dq = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			dq.offerLast(i);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int answer = 0;
		for(int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());
			int fCount = 0;
			int lCount = 0;
			
			// 2�� ����
			for(int i = 0; i < dq.size(); i++) {
				if(num == dq.get(i))
					break;
				fCount++;
			}
			
			// 3�� ����
			for(int i = dq.size()-1; i >= 0; i--) {
				if(num == dq.get(i)) {
					lCount++;
					break;
				}
				lCount++;
			}
			
			// �̹� �տ� ��ġ�� ���
			if(fCount == 0) {
				dq.pollFirst();
				continue;
			}
			// ��
			if(fCount < lCount) {
				answer += fCount;
				
				// �� �ʿ� ���ڰ� �� ������ ���� ��
				while(fCount > 0) {
					dq.offerLast(dq.pollFirst());
					fCount--;
				}
				dq.pollFirst();
			}
			else{
				answer += lCount;
				
				// �� �ʿ� ���ڰ� �� ������ ���� ��
				while(lCount > 0) {
					dq.offerFirst(dq.pollLast());
					lCount--;
				}
				dq.pollFirst();
			}
			
		}
		System.out.println(answer);
		
		
	}

}
