package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BT_2580 {
	
	static int[][] map = new int[9][9];;
	
	public static void main(String[] args) throws IOException {
		// [2580] ������
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
		// �ش� ���� �� ä������ ��� ���� ���� ù ��° ������ ����
		if(col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		// ��� ���� ��� ä������ ��� ��� �� ����
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			
			// ��� �� �ý��� ����
			System.exit(0);
		}
		
		// ���� �ش� ��ġ�� 0�̶�� 1���� 9���� �� ������ �� Ž��
		if(map[row][col] == 0) {
			for(int i = 0; i <= 9; i++) {
				// i���� �ߺ����� �ʴ��� �˻�
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
		// ���� �࿡ �ִ� ���ҵ� �� ��ġ�� �� ���Ұ� �ִ��� �˻�
		for(int i = 0; i < 9; i++) {
			if(map[row][i] == value) {
				return false;
			}
		}
		
		// ���� ���� �ִ� ���ҵ� �� ��ġ�� �� ���Ұ� �ִ��� �˻�
		for(int i = 0; i < 9; i++) {
			if(map[i][col] == value) {
				return false;
			}
		}
		
		// 3*3 ĭ�� �ߺ��Ǵ� ���Ұ� �ִ��� �˻�
		int set_row = (row / 3) * 3; // value�� ���� 3x3�� ���� ù ��ġ
		int set_col = (col / 3) * 3; // value�� ���� 3x3�� ���� ù ��ġ
		
		for(int i = set_row; i < set_row + 3; i++) {
			for(int j = set_col; j < set_col + 3; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		// �ߺ��Ǵ� ���� ���� ��� true ��ȯ
		return true;
		
	}

}
