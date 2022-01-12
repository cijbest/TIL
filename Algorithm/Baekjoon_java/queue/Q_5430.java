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
		// 뒤집을 때 isRight라는 flag를 이용해서 뒤에서부터 처리하도록 한다.
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
		// 명령어 실행
		boolean isRight = true;
		
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == 'R') {
				isRight = (!isRight);
				continue;
			}
			
			// D 함수이면서 isRight가 true 일 경우
			if(isRight) {
				
				// 만약 반환 된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
				if(dq.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
				
			}
			else {
				// 만약 반환 된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
				if(dq.pollLast() == null) {
					sb.append("error\n");
					return;
				}	
			}
		}
		resultPrint(isRight, dq);
	}
	
	public static void resultPrint(boolean isRight, Deque<Integer> dq) {
		sb.append('[');	// 여는 대괄호 먼저 StringBuilder에 저장
		
		if(dq.size() > 0) {	//만약 출력 할 원소가 한 개 이상일 경우
			
			if(isRight) {	// 정방향일경우 
				
				sb.append(dq.pollFirst());	// 먼저 첫 번째 원소를 넘겨준다.
				
				// 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 하나씩 뽑아 넘긴다. 
				while(!dq.isEmpty()) {
					sb.append(',').append(dq.pollFirst());
				}
			}
			else {	// 역방향일경우 
				sb.append(dq.pollLast());	// 먼저 뒤에서부터 첫 번째 원소를 넘겨준다.
				
				// 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 뒤에서부터 하나씩 뽑아 넘긴다. 
				while(!dq.isEmpty()) {
					sb.append(',').append(dq.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
		
	}

}
