package backtracking;

import java.util.*;
import java.io.*;

public class BT_2529 {
	static int k;
	static boolean[] check = new boolean[10]; // �湮����
	static String[] op; // �ε�ȣ ����
	static ArrayList<String> ans = new ArrayList<String>(); // ������ ����� ������ ����Ʈ
	
	static void go(int idx, String num) {
		// ��� ���� ��ġ �Ϸ�
		if(idx == k+1) {
			if(ok(num)) { // ���� üũ
				ans.add(num);
			}
			return;
		}
		// ���� ��� ȣ��
		for(int i = 0; i <= 9; i++) {
			if(check[i]) continue;
			check[i] = true;
			go(idx+1, num+Integer.toString(i));
			check[i] = false;
		}
	}
	static boolean ok(String num) {
		
		for(int i = 0; i < k; i++) {
			if(op[i].equals("<")) { // String�� �� equals!!! == ���� �ν� �ȵ�!!!
				if(num.charAt(i) > num.charAt(i+1)) return false; // ���ڰ� �� �ٸ��Ƿ� ���� ���� �������� �ʾƵ� �ȴ�. 
			}
			else if(op[i].equals(">")) {
				if(num.charAt(i) < num.charAt(i+1)) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2529] �ε�ȣ
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(bf.readLine());
		op = bf.readLine().split(" ");
		
		go(0, "");
		
		Collections.sort(ans);

		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));

	}

}
