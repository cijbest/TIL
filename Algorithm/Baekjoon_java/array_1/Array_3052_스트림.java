package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Array_3052_��Ʈ�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [3052] ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[10];
		for(int i = 0 ; i < 10; i++) {
			num[i] = Integer.parseInt(br.readLine());
			num[i] = num[i] % 42;		
		}
		
		// stream ���
		System.out.println(Arrays.stream(num).distinct().count());

		

	}

}
