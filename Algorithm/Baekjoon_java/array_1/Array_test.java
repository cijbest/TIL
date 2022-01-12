package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Array_test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = {1,2,3,4,5};
		//String[] srr = Stream.of(arr).map(String::valueOf).toArray(String[]::new);

		int[] answer = Arrays.stream(arr).filter(v -> v > 2).toArray();
		for(int a:answer) {
			System.out.print(a+ " ");
		}

	}

}
