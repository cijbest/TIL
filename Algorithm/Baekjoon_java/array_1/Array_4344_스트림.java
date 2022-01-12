package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.StringTokenizer;

public class Array_4344_스트림 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [4344] 평균은 넘겠지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int testcase = 0; testcase < n; testcase++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			double avg = Arrays.stream(arr).skip(1).average().orElse(0);
			int cnt = (int) Arrays.stream(arr).skip(1).filter(val -> val > avg).count();
			System.out.println(String.format("%.3f", (double)cnt/arr[0]*100) + "%");
			//System.out.printf("%.3f%%\n", (double)cnt/arr[0]*100);
		}

		

	}

}
