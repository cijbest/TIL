package string;

import java.util.Scanner;

public class String_3 {

	public static void main(String[] args) {

		// StringBuilder : 한 번에 모아서 출력
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= a; i++) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}

}
