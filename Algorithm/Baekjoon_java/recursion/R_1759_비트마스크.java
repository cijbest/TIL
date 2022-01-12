package recursion;

import java.util.*;
import java.io.*;

public class R_1759_��Ʈ����ũ {
	
	static boolean ok(String letter) {
		int mo = 0;
		int ja = 0;
		for(int i = 0; i < letter.length(); i++) {
			char s = letter.charAt(i);
			if(s == 'a' | s == 'e' | s == 'i' | s == 'o' | s == 'u') mo++;
			else ja++;
			
			if(mo >= 1 && ja >= 2) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// [1759] ��ȣ �����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] alpha = bf.readLine().split(" ");
		
		// ���ĺ��� ������� �����Ѵٰ� �����Ƿ� ����
		Arrays.sort(alpha);
		ArrayList<String> ans = new ArrayList<String>();
		for(int i = 0; i < (1<<C); i++) {
			int lcnt = 0;
			String letter = "";
			for(int k = 0; k < C; k++) {
				if((i & (1<<k)) != 0) {
					lcnt++;
					letter += alpha[k];
				}
			}
			if(lcnt == L) {
				if(ok(letter)) {
					ans.add(letter);
				}
			}
		}
		
		// ���������� ����ؾ� �ϹǷ� ����Ʈ�� ��� ���� �� ���
		Collections.sort(ans);
		for(String x : ans) {
			System.out.println(x);
		}
		

	}

}
