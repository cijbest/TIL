package backtracking;

import java.util.*;
import java.io.*;

public class BT_2529 {
	static int k;
	static boolean[] check = new boolean[10]; // 방문여부
	static String[] op; // 부등호 저장
	static ArrayList<String> ans = new ArrayList<String>(); // 가능한 답들은 저장할 리스트
	
	static void go(int idx, String num) {
		// 모든 숫자 배치 완료
		if(idx == k+1) {
			if(ok(num)) { // 숫자 체크
				ans.add(num);
			}
			return;
		}
		// 다음 경우 호출
		for(int i = 0; i <= 9; i++) {
			if(check[i]) continue;
			check[i] = true;
			go(idx+1, num+Integer.toString(i));
			check[i] = false;
		}
	}
	static boolean ok(String num) {
		
		for(int i = 0; i < k; i++) {
			if(op[i].equals("<")) { // String은 꼭 equals!!! == 쓰면 인식 안됨!!!
				if(num.charAt(i) > num.charAt(i+1)) return false; // 숫자가 다 다르므로 같을 경우는 따져주지 않아도 된다. 
			}
			else if(op[i].equals(">")) {
				if(num.charAt(i) < num.charAt(i+1)) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2529] 부등호
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(bf.readLine());
		op = bf.readLine().split(" ");
		
		go(0, "");
		
		Collections.sort(ans);

		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));

	}

}
