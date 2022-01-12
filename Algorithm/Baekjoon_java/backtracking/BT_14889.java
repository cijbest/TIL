package backtracking;

import java.util.*;
import java.io.*;

public class BT_14889 {
	static int n;
	static int[][] a;
	
	static int go(int idx, ArrayList<Integer> first, ArrayList<Integer> second) {
		// �Ұ����� ��� : Ž���� �Ϸ���� �� �����̶� 4���� �� �Ǹ� �Ұ����̶� �Ǵ�
		if(idx == n && (first.size() != n/2 || second.size() != n/2)){
			return -1;
		}
		
		// ���� ã�� ���
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
		// -1�̶� ���� ���� n�� �������� ���� ���� = ù��°�� ��ȯ�Ǵ� ���̰��� ���´�, ù ���̰����� �����ؼ� ���� ���� ���̰� ã�� 
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
		// [14889] ��ŸƮ�� ��ũ
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
