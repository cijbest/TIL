package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UF_1976 {
	
	public static int n, m;
	public static int[] parent;
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// [1976] 여행 가자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 1;
			while(st.hasMoreTokens()) {
				if(Integer.parseInt(st.nextToken()) == 1) { 
					unionParent(i+1, j);
				}
				j++;
			}
		}
		
		ArrayList<Integer> trip = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			trip.add(Integer.parseInt(st.nextToken()));
		}
		
		boolean isPossible = true;
		
		for(int i = 0; i < trip.size()-1; i++) {
			if(findParent(trip.get(i)) != findParent(trip.get(i+1))) {
				isPossible = false;
				break;
			}
		}
		if(isPossible) System.out.println("YES");
		else System.out.println("NO");
	}

}
