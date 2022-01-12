package samsung;

import java.util.*;
import java.io.*;

class Data implements Comparable<Data>{
	int x, y, like, empty;
	Data(int x, int y, int like, int empty){
		this.x = x; // 행
		this.y = y; // 열
		this.like = like; // 좋아하는 학생 수 있을 때
		this.empty= empty; // 빈칸일 때
	}
	// like -> empty -> x(행) -> y(열) 순으로 정렬 
	// like, empty는 내림차순 / x, y는 오름차순  => 다중정렬
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
	static int[] order; // 학생들 배치 순서
	static ArrayList<Integer>[] students; // 학생들이 좋아하는 학생들을 저장 (인덱스 = 학생)
	static int[][] check; // 학생 배치
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4방향
	static PriorityQueue<Data> q = new PriorityQueue<Data>(); // 큐에 넣어서 정렬하고자 할 때 사용

	static void go(int student) {
		
		int like = 0;
		int empty = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(check[i][j] != 0) continue; // 이미 학생이 배치되어있으면 패스
				for(int k = 0; k < 4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					if(0 < nx && nx <= n && 0 < ny && ny <= n) {
						// 좋아하는 학생이 인접한 수를 카운팅
						if(check[nx][ny] == students[student].get(0) || check[nx][ny] == students[student].get(1) || check[nx][ny] == students[student].get(2) || check[nx][ny] == students[student].get(3)) {
							like++;
						}
						// 비어 있는 수를 카운팅
						else if(check[nx][ny] == 0) {
							empty++;
						}
					}
				}
				// 우선순위 큐에 넣기
				q.add(new Data(i, j, like, empty));
				// 초기화(다음 칸을 조사하기 위해)
				like = 0; empty = 0;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [21608] 상어초등학교
		// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
		// 2. 1을만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
		// 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
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

		// 자리 배치
		check = new int[n+1][n+1];
		for(int i = 0;  i < n*n; i++) {
			int student = order[i];
			go(student); // 자리 조사
			Data d = q.poll(); // 최적의 조건 하나 추출
			check[d.x][d.y] = student; // 배치
			q.clear(); // 우선순위 큐 비우기
		}
		
		// 만족도 구하기
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
