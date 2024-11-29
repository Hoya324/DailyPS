class Solution {
    
    public int dfs(int[] numbers, int index, int currentTotal, int target) {
        
        if (index == numbers.length) {
            return currentTotal == target ? 1 : 0;
        }
        
        return dfs(numbers, index + 1, currentTotal + numbers[index], target) + dfs(numbers, index + 1, currentTotal - numbers[index], target);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }
}