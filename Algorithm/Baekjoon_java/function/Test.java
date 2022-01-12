package function;

// [15596] 정수 N개의 합
public class Test {
	long sum(int[] a) {
		long ans = 0;
		//for(long data: a) {
		for(int i = 0; i < a.length; i++) { // 위의 것보다 더 빠르다
			ans += a[i];
		}
		return ans;
	}
}
