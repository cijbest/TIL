class Solution {
    static boolean[][] visited;

	public void dfs(int i, int n, int[][] computers) { // 탐색하면서 방문 여부를 체크
		for(int j  = 0 ; j < n ; j++) {
			if(computers[i][j] == 1 && !visited[i][j]) {
				visited[i][j] = visited[j][i] = true;
				dfs(j, n, computers);
			}
		}
	}
    public int solution(int n, int[][] computers) {
        int answer = 0;
		visited = new boolean[n][n];
		
		for(int i = 0 ;i < n;i++) {
			if(!visited[i][i]) { 
				dfs(i, n, computers);
				answer++;
			}
		}
		
		return answer;
    }
}