package function;

// [15596] ���� N���� ��
public class Test {
	long sum(int[] a) {
		long ans = 0;
		//for(long data: a) {
		for(int i = 0; i < a.length; i++) { // ���� �ͺ��� �� ������
			ans += a[i];
		}
		return ans;
	}
}
