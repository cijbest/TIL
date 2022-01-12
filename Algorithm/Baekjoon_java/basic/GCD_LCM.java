package basic;

import java.util.Scanner;

public class GCD_LCM {
	// 최대공약수 : 두 수를 나눌 수 있는 수 중 가장 큰 거
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	 
	// 최소공배수 : 두 수의 공통인 배수 중 작은 거
	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("최대공약수 : " + gcd(a, b));
		System.out.println("최소공배수 : " + lcm(a, b));

	}

}
