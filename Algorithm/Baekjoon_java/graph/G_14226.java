package graph;

import java.util.*;
import java.io.*;

class Emo{
	int x, y;
	long cnt;
	Emo(int x, int y, long cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class G_14226 {
	static int S;
	static long ans;
	static boolean[][] check = new boolean[1001][1001];
	
	static void bfs(int moni, int clip) {
		Queue<Emo> q = new LinkedList<Emo>();
		q.add(new Emo(moni, clip, 0));
		while(!q.isEmpty()) {
			Emo e = q.poll();
			if(e.x == S) {
				ans = e.cnt;
				break;
			}
			
			// 화면에서 이모티콘 1개 뺄 때
			if(e.x - 1 >= 0 && !check[e.x-1][e.y]) {
				check[e.x-1][e.y] = true;
				q.add(new Emo(e.x-1, e.y, e.cnt+1));
			}
			// 클립보드에 있는 이모티콘 붙여넣기
			if(e.x + e.y <= S && !check[e.x+e.y][e.y]) {
				check[e.x+e.y][e.y] = true;
				q.add(new Emo(e.x+e.y, e.y, e.cnt+1));
			}
			// 클립보드에 복사
			if(!check[e.x][e.x]) {
				check[e.x][e.x] = true;
				q.add(new Emo(e.x, e.x, e.cnt+1));
				
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [14226] 이모티콘
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(bf.readLine());
		bfs(1, 0);
		System.out.println(ans);
	}

}
