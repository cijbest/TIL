package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
	int x, y;
	Queue<Point> q = new LinkedList<Point>();

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Queue<Point> q) {
		this.x = x;
		this.y = y;
		this.q = q;
	}
}

public class Test {
	static int[][] a, b;
	
	static void printA() {
		for(int i = 0 ; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void printB() {
		for(int i = 0 ; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] a = new int[11][11];
		
		
		
		long start = System.currentTimeMillis();
		String s = "";
		for(int i = 1; i < 10; i++) {
			s += i + " " + (i+1) + " ";
		}
		st = new StringTokenizer(s, " ");
		while(st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = 1;
		}
		
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
		
		start = System.currentTimeMillis();
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 1; i < 10; i++) {
			q.add(new Point(i, i+1));
		}
		while(!q.isEmpty()) {
			Point e = q.poll();
			a[e.x][e.y] = 1;
		}
		
		end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);

		Queue<Point> qq = new LinkedList<Point>();
		for(int i = 1; i < 10; i++) {
			qq.add(new Point(i, i+1));
		}
		Point p = new Point(1,2,qq);
		Queue<Point> tmp = p.q;
		while(!tmp.isEmpty()) {
			System.out.println(tmp.poll().x);
		}

	}

}
