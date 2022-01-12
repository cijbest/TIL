package samsung;

import java.util.*;
import java.io.*;

class Data implements Comparable<Data>{
	int x, y, like, empty;
	Data(int x, int y, int like, int empty){
		this.x = x; // ��
		this.y = y; // ��
		this.like = like; // �����ϴ� �л� �� ���� ��
		this.empty= empty; // ��ĭ�� ��
	}
	// like -> empty -> x(��) -> y(��) ������ ���� 
	// like, empty�� �������� / x, y�� ��������  => ��������
	@Override
	public int compareTo(Data o) {
		if(this.like == o.like) {
			if(this.empty == o.empty) {
				if(this.x == o.x) return this.y - o.y;
				else return this.x - o.x;
			}else return o.empty - this.empty;
		}
		else return o.like - this.like;
	}
}

public class S_21608 {
	static int n;
	static int[] order; // �л��� ��ġ ����
	static ArrayList<Integer>[] students; // �л����� �����ϴ� �л����� ���� (�ε��� = �л�)
	static int[][] check; // �л� ��ġ
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4����
	static PriorityQueue<Data> q = new PriorityQueue<Data>(); // ť�� �־ �����ϰ��� �� �� ���

	static void go(int student) {
		
		int like = 0;
		int empty = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(check[i][j] != 0) continue; // �̹� �л��� ��ġ�Ǿ������� �н�
				for(int k = 0; k < 4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					if(0 < nx && nx <= n && 0 < ny && ny <= n) {
						// �����ϴ� �л��� ������ ���� ī����
						if(check[nx][ny] == students[student].get(0) || check[nx][ny] == students[student].get(1) || check[nx][ny] == students[student].get(2) || check[nx][ny] == students[student].get(3)) {
							like++;
						}
						// ��� �ִ� ���� ī����
						else if(check[nx][ny] == 0) {
							empty++;
						}
					}
				}
				// �켱���� ť�� �ֱ�
				q.add(new Data(i, j, like, empty));
				// �ʱ�ȭ(���� ĭ�� �����ϱ� ����)
				like = 0; empty = 0;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [21608] ����ʵ��б�
		// 1. ����ִ� ĭ �߿��� �����ϴ� �л��� ������ ĭ�� ���� ���� ĭ���� �ڸ��� ���Ѵ�.
		// 2. 1�������ϴ� ĭ�� ���� ���̸�, ������ ĭ �߿��� ����ִ� ĭ�� ���� ���� ĭ���� �ڸ��� ���Ѵ�.
		// 3. 2�� �����ϴ� ĭ�� ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ĭ����, �׷��� ĭ�� ���� ���̸� ���� ��ȣ�� ���� ���� ĭ���� �ڸ��� ���Ѵ�.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		order = new int[n*n +1]; 
		students = new ArrayList[n*n+1];
		for(int i = 1; i <= n*n; i++) {
			students[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n*n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			order[i] =  Integer.parseInt(st.nextToken());
			for(int j = 0; j < 4; j++) {
				students[order[i]].add(Integer.parseInt(st.nextToken()));
			}
		}

		// �ڸ� ��ġ
		check = new int[n+1][n+1];
		for(int i = 0;  i < n*n; i++) {
			int student = order[i];
			go(student); // �ڸ� ����
			Data d = q.poll(); // ������ ���� �ϳ� ����
			check[d.x][d.y] = student; // ��ġ
			q.clear(); // �켱���� ť ����
		}
		
		// ������ ���ϱ�
		int cnt = 0;
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				int student = check[i][j];
				for(int k = 0; k < 4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					if(0 < nx && nx <= n && 0 < ny && ny <= n) {
						if(check[nx][ny] == students[student].get(0) || check[nx][ny] == students[student].get(1) || check[nx][ny] == students[student].get(2) || check[nx][ny] == students[student].get(3)) {
							cnt++;
						}
					}
				}
				if(cnt == 0) sum += 0;
				else if(cnt == 1) sum += 1;
				else if(cnt == 2) sum += 10;
				else if(cnt == 3) sum += 100;
				else sum += 1000;
				cnt = 0;
			}
		}
		
		System.out.println(sum);

	}

}
