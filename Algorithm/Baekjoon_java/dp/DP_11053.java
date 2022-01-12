package dp;

import java.io.*;
import java.util.StringTokenizer;

public class DP_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [11053] ���� �� �����ϴ� �κ� ����
		// ������ ��ġ������ ���� �����ϴ� �κ��� �ִ���̸� ���Ѵ�.
		// ���� dp�迭���� �ִ밪 ã��
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int[] a = new int[n+1];
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dp[i] = 1; // �⺻��
			for(int j = 1; j < i; j++) {
				if(a[j] < a[i] && dp[j]+1 > dp[i])
					dp[i] = dp[j] + 1;
			}
		}
		int max = dp[0];
		for(int tmp : dp) {
			if(tmp > max)
				max = tmp;
		}
		System.out.println(max);
	}

}
