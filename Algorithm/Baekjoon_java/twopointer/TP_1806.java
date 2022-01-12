package twopointer;

import java.util.*;
import java.io.*;

public class TP_1806 {

	public static void main(String[] args) throws IOException {
		// [1806] 부분합
		// 1.시작점과 끝점이 첫번째 원소의 인덱스를 가리키도록 한다.
		// 2.현재 부분 합이 M과 같다면 카운트한다.
		// 3.현재 부분 합이 M보다 작다면 end를 1 증가시킨다.
		// 4.현재 부분 합이 M보다 크거나 같다면 start를 1 증가시킨다.
		// 5.모든 경우를 확인할 때까지 2-4번 과정을 반복한다.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		long sum = 0;
		int min = 100001;
		while (true) {
            if (sum >= s) { //조건 만족
                sum -= a[start];
                min = Math.min(min, (end - start)); // 부분합 최소 길이 갱신
                start++; // 왼쪽 포인터 오른쪽으로 이동
            } else if (end == n) { //끝 도달
                break;
            } else { // right포인터 오른쪽으로 이동
                sum += a[end++];
            }
        }
		if(min == 100001) System.out.println(0);
		else System.out.println(min);

	}

}
