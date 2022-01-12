package array_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Array_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [8958] OXÄûÁî
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] OX = new String[n];
		for(int i = 0 ; i < n; i++) {
			OX[i] = br.readLine();
			int sum = 0;
			int score = 1;
			for(int j = 0; j < OX[i].length(); j++) {
				if(OX[i].charAt(j) == 'X') {
					score = 1;
					continue;
				}
				sum += score;
				score++;
			}
			System.out.println(sum);
		}


		

	}

}
