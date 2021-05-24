class Solution {
    public int dfs(int[] numbers, int target, int i, int sum){
        if(i == numbers.length){
            if(sum == target) return 1;
            return 0;
        }
        return dfs(numbers, target, i+1, sum + numbers[i]) 
            + dfs(numbers, target, i+1, sum - numbers[i]);

    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
}