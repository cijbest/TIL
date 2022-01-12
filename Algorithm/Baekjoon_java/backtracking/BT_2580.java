package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BT_2580 {
	
	static int[][] map = new int[9][9];;
	
	public static void main(String[] args) throws IOException {
		// [2580] 스도쿠
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int row = 0; row < 9; row++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for(int col = 0; col < 9; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);

	}
	
	public static void sudoku(int row, int col) {
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if(col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			
			// 출력 뒤 시스템 종료
			System.exit(0);
		}
		
		// 만약 해당 위치가 0이라면 1부터 9까지 중 가능한 수 탐색
		if(map[row][col] == 0) {
			for(int i = 0; i <= 9; i++) {
				// i값이 중복되지 않는지 검사
				if(possibility(row, col, i)) {
					map[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			map[row][col] = 0;
			return;
		}
		
		sudoku(row, col + 1);
		
	}
	
	public static boolean possibility(int row, int col, int value) {
		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for(int i = 0; i < 9; i++) {
			if(map[row][i] == value) {
				return false;
			}
		}
		
		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for(int i = 0; i < 9; i++) {
			if(map[i][col] == value) {
				return false;
			}
		}
		
		// 3*3 칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
		
		for(int i = set_row; i < set_row + 3; i++) {
			for(int j = set_col; j < set_col + 3; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		// 중복되는 것이 없을 경우 true 반환
		return true;
		
	}

}
