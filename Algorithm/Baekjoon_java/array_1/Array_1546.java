package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Array_1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1546] ЦђБе
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		double[] score = new double[n];
		double max = 0;
		double sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());	
			if(score[i] > max)
				max = score[i];
			sum += score[i];
		}

		System.out.println(sum / n / max * 100);

		

	}

}
