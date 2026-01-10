class Solution {
    
    public class Result {
        String binary;
        int removedZeroCount;
        int beforeLength;
        
        public Result(String binary, int removedZeroCount, int beforeLength) {
            this.binary = binary;
            this.removedZeroCount = removedZeroCount;
            this.beforeLength = beforeLength;
        }
    }
    
    public int[] solution(String s) {
        // 0을 제거하고, 제거 후 길이를 반환
        int totalRemovedZeroCount = 0;
        int step = 0;
        Result result;
        String target = s;
        
        while (step == 0 || !target.equals("1")) {
            result = process(target);
            totalRemovedZeroCount += result.removedZeroCount;
            step++;
            target = result.binary;
        }
        
        int[] answer = new int[2];
        answer[0] = step;
        answer[1] = totalRemovedZeroCount;       
        return answer;
    }
    
    private Result process(String targetBinary) {
        // 0 제거
        String removedZero = targetBinary.replace("0", "");
        
        int removedZeroCount = targetBinary.length() - removedZero.length();
        int beforeLength = removedZero.length();
        
        // 2진수로 변환
        String newBinary = Integer.toBinaryString(beforeLength);
        
        return new Result(newBinary, removedZeroCount, beforeLength);
    }
}