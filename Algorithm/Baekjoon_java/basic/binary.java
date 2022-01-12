package basic;

public class binary {
	
	static String change(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while(n >= 1) {
			sb.insert(0, n%k);
			n /= k;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// 2, 8, 16���� �����
		int  n = 127;
		System.out.println(Integer.toBinaryString(n)); // 2����
		System.out.println(Integer.toOctalString(n)); // 8����
		System.out.println(Integer.toHexString(n)); // 16����
		
		System.out.println();
		
		// 2, 8, 16���� -> 10����
		System.out.println(Integer.parseInt(Integer.toBinaryString(n), 2));
		System.out.println(Integer.parseInt(Integer.toOctalString(n), 8));
		System.out.println(Integer.parseInt(Integer.toHexString(n), 16));
		
		System.out.println();
		
		// k���� �����
		System.out.println(change(n, 3));

	}

}
