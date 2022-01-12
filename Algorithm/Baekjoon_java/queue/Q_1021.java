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
		// [1021] 회전하는 큐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 큐의 크기
		int M = Integer.parseInt(st.nextToken()); // 뽑아내고자하는 수의 개수
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
			
			// 2번 연산
			for(int i = 0; i < dq.size(); i++) {
				if(num == dq.get(i))
					break;
				fCount++;
			}
			
			// 3번 연산
			for(int i = dq.size()-1; i >= 0; i--) {
				if(num == dq.get(i)) {
					lCount++;
					break;
				}
				lCount++;
			}
			
			// 이미 앞에 위치한 경우
			if(fCount == 0) {
				dq.pollFirst();
				continue;
			}
			// 비교
			if(fCount < lCount) {
				answer += fCount;
				
				// 앞 쪽에 숫자가 더 가까이 있을 때
				while(fCount > 0) {
					dq.offerLast(dq.pollFirst());
					fCount--;
				}
				dq.pollFirst();
			}
			else{
				answer += lCount;
				
				// 끝 쪽에 숫자가 더 가까이 있을 때
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
