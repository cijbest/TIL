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
		// 2���� ���������Ƿ�, ����� ����ϰ� ��͸� �����Ѵ�.
		if (cnt == 2) {
			permu.add(result.split(" "));
//			System.out.println(result);
			return;
		}
		// ��� ������ ��ȸ�ϸ� ���ڸ� �ϳ� �����Ѵ�.
		for (int i = 0; i < alen; i++) {
			// �̹� �ش� ���ڸ� ������ ��쿡�� ��ŵ.
			if (visited[i]) {
				continue;
			}
			// �������� �������, �����ߴٴ� ǥ�ø� ���ش�.
			visited[i] = true;
			// �ڽ��� ��� ȣ���Ѵ�.
			permutation(cnt + 1, result + arr[i] + " ");
			// ������ �����Ѵ�.
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		
		// ����
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
		
		// ���� - ���
		permutation(0, "");
		for(String[] p : permu) {
			for(String ps: p) {
				System.out.print(ps + " ");
			}
			System.out.println();
		}
		
	

	}

}
