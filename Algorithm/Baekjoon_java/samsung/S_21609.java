package samsung;

import java.util.*;
import java.io.*;

class Block implements Comparable<Block>{
	int x, y, size, rCnt;
	String points;
	Block(int x, int y, int size, int rCnt, String points){
		this.x = x;
		this.y = y;
		this.size = size;
		this.rCnt = rCnt;
		this.points = points;
	}
	Block(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Block o) {
		if(this.size == o.size) {
			if(this.rCnt == o.rCnt) {
				if(this.x == o.x) {
					return o.y - this.y;
				}else return o.x - this.x;
			}return o.rCnt - this.rCnt;
		}return o.size - this.size;
	}
		
}
public class S_21609 {
	static int n, m;
	static int[][] map;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4����
	static PriorityQueue<Block> selectedQ = new PriorityQueue<Block>(); // ã�� ��� �׷� ����
	static boolean[][] visited;
	static int BLANK = -2;
	static int ans = 0;
	
	static void findBigBlock() {
		// �׷쿡 �ѹ� ���ԵǾ����� �ٽ� ã�� �ʾƵ� �ȴ�. �׷��Ƿ� visited���� ������ �κи� �ٽ� false�� �ٲپ��ָ� �ȴ�.
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] > 0 && map[i][j] <= m) {
					bfs(i, j);
				}
			}
		}
	}
	static void bfs(int x, int y) {
		visited[x][y] = true;
		int size = 1;
		int rCnt = 0;
		int color = map[x][y];
		String points = x+" "+y+" ";
		Queue<Block> rq = new LinkedList<Block>();
		Queue<Block> q = new LinkedList<Block>();
		q.add(new Block(x, y));
		
		while(!q.isEmpty()) {
			Block b = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = b.x + dir[i][0];
				int ny = b.y + dir[i][1];
				if(0 <= nx && nx < n && 0 <= ny && ny < n) {
					if(!visited[nx][ny]) {
						if(map[nx][ny] == color || map[nx][ny] == 0) {
							if(map[nx][ny] == 0) {
								rCnt++; // ������
								rq.add(new Block(nx, ny));
							}
							q.add(new Block(nx, ny));
							points += nx+" "+ny+" ";
							visited[nx][ny] = true;
							size++;
						}
					}
				}
			}
		}
		if(size >= 2) selectedQ.add(new Block(x, y, size, rCnt, points));
		while(!rq.isEmpty()) {
			Block b = rq.poll();
			visited[b.x][b.y] = false;
		}
	}
	
	static void gravity() {
		for(int i = 0; i < n; i++) { // ��
			for(int j = n-1; j >= 0; j--) { // ��
				if(map[j][i] == BLANK || map[j][i] == -1) continue;
				int idx = j+1;
				while(true) {
					if(idx == n) break;
					else if(map[idx][i] == BLANK) idx++;
					else break;
				}
				if(idx == j+1) continue; // ���̻� ������ �� ���� ����� ��ġ�ϰ� �ִ�.
				map[idx-1][i] = map[j][i];
				map[j][i] = BLANK;
				
			}
		}
	}
	
	static void rotate() {
		int[][] b = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				b[i][j] = map[j][(n-1)-i];
			}
		}
		for(int i = 0; i < n; i++) {
			System.arraycopy(b[i], 0, map[i], 0, n);
		}
	}

	public static void main(String[] args) throws IOException {
		// [21609] ������б�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // ���� ����
		m = Integer.parseInt(st.nextToken()); // ���� ����
		if(n == 1) {
			System.out.println(0);
			System.exit(0);
		}
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// ���� ū ��� ã��
		findBigBlock();
		while(!selectedQ.isEmpty()) {
			// �������
			Block big = selectedQ.poll();
			st = new StringTokenizer(big.points, " ");
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = BLANK;
			}
			ans += (big.size * big.size); // ���� ���
			gravity(); // �߷�
			rotate(); // �ݽð� 90�� ȸ��
			gravity();
			selectedQ.clear();
			findBigBlock();
		}
		
		System.out.println(ans);
		
		
	}

}
