package tree;

import java.io.*;
import java.util.*;

class Edge2 {
    int to, cost;
    Edge2(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
class Pair {
    public int diameter;
    public int height;
    Pair(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

public class TREE_1967_2 {
	static ArrayList<Edge2>[] a;
    static boolean[] check = new boolean[10001];
    static Pair dfs(int x) {
        check[x] = true;
        ArrayList<Integer> heights = new ArrayList<>();
        int ans = 0;
        for (Edge2 e : a[x]) {
            int y = e.to;
            int cost = e.cost;
            if (check[y] == false) {
                Pair p = dfs(y);
                if (ans < p.diameter) ans = p.diameter;
                heights.add(p.height+cost);
            }
        }
        int height = 0;
        Collections.sort(heights, Collections.reverseOrder());
        if (heights.size() >= 1) {
            height = heights.get(0);
            if (ans < height) {
                ans = height;
            }
        }
        if (heights.size() >= 2) {
            int temp = heights.get(0) + heights.get(1);
            if (ans < temp) {
                ans = temp;
            }
        }
        return new Pair(ans, height);
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1967] 트리의 지름
		// (2) 포스트오더로 탐색하는 방법
		// 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        a = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Edge2>();
        }
        
        for (int i = 0; i < n-1; i++) {
        	StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            a[u].add(new Edge2(v, w));
            a[v].add(new Edge2(u, w));
        }
        Pair ans = dfs(1);
        System.out.println(ans.diameter);
	}

}
