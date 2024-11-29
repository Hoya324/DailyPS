class Solution {
    
    public int getTargetTotal(int[] numbers, int index, int currentTotal, int target) {
        
        if (index == numbers.length) {
            return currentTotal == target ? 1 : 0;
        }
        
        return getTargetTotal(numbers, index + 1, currentTotal + numbers[index], target) + getTargetTotal(numbers, index + 1, currentTotal - numbers[index], target);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = getTargetTotal(numbers, 0, 0, target);
        return answer;
    }
}
