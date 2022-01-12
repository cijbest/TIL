package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IBM_3 {
	static int ans;
	
	static void go(List<Integer> arrival, List<Integer> duration, int now, int cnt) {
		int last = arrival.get(arrival.size()-1) + duration.get(duration.size()-1);
		if(now > last) {
			if(ans < cnt-1)
				ans = cnt-1;
			return;
		}
		if(now == last) {
			if(ans < cnt)
				ans = cnt;
			return;
		}
			
		for(int i = 0; i < arrival.size(); i++) {
			if(arrival.get(i) == now) {
				go(arrival, duration, now+duration.get(i), cnt+1);
			}
		}
	}
	
	static int sol(List<Integer> arrival, List<Integer> duration) {
		go(arrival, duration, arrival.get(0), 0);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		List<Integer> arrival = new ArrayList<Integer>();
		List<Integer> duration = new ArrayList<Integer>();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		while(st.hasMoreTokens()) {
			arrival.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		while(st.hasMoreTokens()) {
			duration.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(sol(arrival, duration));

	}

}
