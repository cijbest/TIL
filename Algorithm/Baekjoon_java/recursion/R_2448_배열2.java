package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class R_2448_¹è¿­2 {
	
	static char[][] arr;
	
	public static void star(int x, int y, int n) {
	
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		
		int size = n/3;
		int count = 0;
		for(int i = x; i < x+n; i+=size) {
			for(int j = y; j < y+n; j+=size) {
				count++;
				if(count != 5)
					star(i, j, size);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2447] º°Âï±â
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for(int i = 0; i < n; i++)
			Arrays.fill(arr[i], ' ');	
		star(0, 0, n);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

}
