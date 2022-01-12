package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_11729 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11729] 하노이 탑 이동순서
		// 참고 : https://shoark7.github.io/programming/algorithm/tower-of-hanoi
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		// 하노이 탑 이동 공식 계산 결과 
		System.out.println((int)Math.pow(2, k) -1);
		hanoi(k, 1, 3, 2);
		
		System.out.println(sb);

	}
	
	public static void hanoi(int n, int start, int end, int via) {
		if(n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		// A -> B
		hanoi(n-1, start, via, end);
		// A -> C
		sb.append(start + " " + end + "\n");
		// B -> C
		hanoi(n-1, via, end, start);
	}

}
