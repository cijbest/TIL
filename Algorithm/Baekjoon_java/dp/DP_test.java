package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DP_test {
	
	static int[] arr = new int[] {11, 22, 33};
	static int alen = arr.length;
	
	static boolean[] visited = new boolean[alen];
	
	static ArrayList<String[]> permu = new ArrayList<>();
	
	static void permutation(int cnt, String result) {
		// 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
		if (cnt == 2) {
			permu.add(result.split(" "));
//			System.out.println(result);
			return;
		}
		// 대상 집합을 순회하며 숫자를 하나 선택한다.
		for (int i = 0; i < alen; i++) {
			// 이미 해당 숫자를 선택한 경우에는 스킵.
			if (visited[i]) {
				continue;
			}
			// 선택하지 않은경우, 선택했다는 표시를 해준다.
			visited[i] = true;
			// 자신을 재귀 호출한다.
			permutation(cnt + 1, result + arr[i] + " ");
			// 선택을 해제한다.
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		
		// 조합
		for(int i = 0; i < (1 << alen); i++) {
			if(Integer.bitCount(i) == 2) {
				ArrayList<Integer> ans = new ArrayList<Integer>();
				for(int k = 0; k < alen; k++) {
					if((i & (1 << k)) != 0) {
						ans.add(arr[k]);
					}
				}
				System.out.println(ans.toString());
			}
		}
		
		// 순열 - 재귀
		permutation(0, "");
		for(String[] p : permu) {
			for(String ps: p) {
				System.out.print(ps + " ");
			}
			System.out.println();
		}
		
	

	}

}
