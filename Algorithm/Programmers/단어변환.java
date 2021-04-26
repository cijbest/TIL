class Solution {
    static boolean[] visited;
	static int MIN = 0;
	
	public static boolean oneCnt(String a, String b) {
		int cnt = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				cnt++;
				if(cnt > 1) return false;
			}
		}
		return true;
	}
	public static void dfs(String begin, String target, String[] words, int total) {
		if(begin.equals(target)) MIN = (MIN == 0)? total :Math.min(MIN, total);
		for(int i = 0; i < words.length; i++) {
			if(begin == words[i]) continue;
			if(!visited[i] && oneCnt(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, total+1);
				visited[i] = false;
			}
		}
	}
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        
        return MIN;
    }
}