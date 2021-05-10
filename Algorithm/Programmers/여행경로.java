import java.util.*;
class Solution {
    static ArrayList<String> arr = new ArrayList<>();
	static String answer = "";
	static boolean[] visited;
	
	public static void dfs(String[][] tickets, int cnt, String end) {
		answer += end + ",";
		if(cnt == tickets.length) {arr.add(answer); return;}
		for(int i = 0; i < tickets.length; i++) {
			if(!visited[i] && end.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets, cnt+1, tickets[i][1]);
				visited[i] = false; answer = answer.substring(0, answer.length()-4);
			}
		}
	}
    public String[] solution(String[][] tickets) {
        int len = tickets.length;

		for(int i = 0; i < tickets.length; i++) {
			visited = new boolean[len];
			String start = tickets[i][0]; String end = tickets[i][1];
			if(start.equals("ICN")) {
				visited[i] = true;
				answer = start + ",";
				dfs(tickets, 1, end);
			}
		}
		Collections.sort(arr);
		String[] ans = arr.get(0).split(",");
		return ans;
    }
}