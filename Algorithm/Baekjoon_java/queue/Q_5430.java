package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q_5430 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [5430] AC
		// ������ �� isRight��� flag�� �̿��ؼ� �ڿ������� ó���ϵ��� �Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			Deque<Integer> dq = new ArrayDeque<Integer>();

			while(st.hasMoreTokens()) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			}
			
			AC(p, dq);
		}
		System.out.println(sb);
	}
	
	public static void AC(String p, Deque<Integer> dq) {
		// ��ɾ� ����
		boolean isRight = true;
		
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == 'R') {
				isRight = (!isRight);
				continue;
			}
			
			// D �Լ��̸鼭 isRight�� true �� ���
			if(isRight) {
				
				// ���� ��ȯ �� ���Ұ� ���� ��� error�� ����ϵ��� �ϰ� �Լ� ����
				if(dq.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
				
			}
			else {
				// ���� ��ȯ �� ���Ұ� ���� ��� error�� ����ϵ��� �ϰ� �Լ� ����
				if(dq.pollLast() == null) {
					sb.append("error\n");
					return;
				}	
			}
		}
		resultPrint(isRight, dq);
	}
	
	public static void resultPrint(boolean isRight, Deque<Integer> dq) {
		sb.append('[');	// ���� ���ȣ ���� StringBuilder�� ����
		
		if(dq.size() > 0) {	//���� ��� �� ���Ұ� �� �� �̻��� ���
			
			if(isRight) {	// �������ϰ�� 
				
				sb.append(dq.pollFirst());	// ���� ù ��° ���Ҹ� �Ѱ��ش�.
				
				// �� ���� ���Һ��� ������ ���� �Ѱ��� �� ���� ���Ҹ� �ϳ��� �̾� �ѱ��. 
				while(!dq.isEmpty()) {
					sb.append(',').append(dq.pollFirst());
				}
			}
			else {	// �������ϰ�� 
				sb.append(dq.pollLast());	// ���� �ڿ������� ù ��° ���Ҹ� �Ѱ��ش�.
				
				// �� ���� ���Һ��� ������ ���� �Ѱ��� �� ���� ���Ҹ� �ڿ������� �ϳ��� �̾� �ѱ��. 
				while(!dq.isEmpty()) {
					sb.append(',').append(dq.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');	// �ݴ� ���ȣ �� �������� ������
		
	}

}
