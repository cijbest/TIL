package backtracking;

import java.util.*;
import java.io.*;

public class BT_14889 {
	static int n;
	static int[][] a;
	
	static int go(int idx, ArrayList<Integer> first, ArrayList<Integer> second) {
		// 불가능한 경우 : 탐색이 완료됐을 때 한쪽이라도 4명이 안 되면 불가능이라 판단
		if(idx == n && (first.size() != n/2 || second.size() != n/2)){
			return -1;
		}
		
		// 정답 찾을 경우
		if(idx == n) {
//			if (first.size() != n/2) return -1;
//          if (second.size() != n/2) return -1;
			int sumF = 0, sumS = 0;
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < n/2; j++) {
					if(i == j) continue;
					sumF += a[first.get(i)][first.get(j)];
					sumS += a[second.get(i)][second.get(j)];
				}
			}
			int diff = Math.abs(sumF - sumS);
			return diff;
			
		}
		
		int ans = -1;
		first.add(idx);
		int t1 = go(idx+1, first, second);
		// -1이란 값은 아직 n에 도달하지 않은 상태 = 첫번째로 반환되는 차이값이 들어온다, 첫 차이값부터 시작해서 가장 작은 차이값 찾기 
		if(ans == -1 || (t1 != -1 && ans > t1)) { 
			ans = t1;
		}
		first.remove(first.size()-1);
		
		second.add(idx);
		int t2 = go(idx+1, first, second);
		if(ans == -1 || (t2 != -1 && ans > t2)) {
			ans = t2;
		}
		second.remove(second.size()-1);
		return ans;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [14889] 스타트와 링크
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		System.out.println(go(0, first, second));
	}

}
