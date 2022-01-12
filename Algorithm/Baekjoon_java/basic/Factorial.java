package basic;

public class Factorial {

	static int fact(int n) {
		if(n == 1) return 1;
		return n * fact(n-1);
	}
	public static void main(String[] args) {
		// ÆÑÅä¸®¾ó = n!
		int n = 5; //120
		System.out.println(fact(n));

	}

}
