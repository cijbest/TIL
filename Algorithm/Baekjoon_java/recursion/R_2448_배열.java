package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_2448_�迭 {
	
	static char[][] arr;
	
	public static void star(int x, int y, int n, boolean blank) {
		
		if(blank) {
			for(int i = x; i < x+n; i++) {
				for(int j = y; j < y+n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		
		int size = n/3;
		int count = 0;
		for(int i = x; i < x+n; i+=size) {
			for(int j = y; j < y+n; j+=size) {
				count++;
				if(count == 5)
					star(i, j, size, true);
				else
					star(i, j, size, false);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [2447] �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
				
		star(0, 0, n, false);
		
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
