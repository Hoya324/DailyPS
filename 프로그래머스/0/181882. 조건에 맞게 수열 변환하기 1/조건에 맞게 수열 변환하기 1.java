class Solution {
    public int[] solution(int[] arr) {
        int[] answer = arr.clone();
        for (int i = 0; i < answer.length; i++) {
            int currentNum = answer[i];
            if (currentNum < 50 && currentNum % 2 != 0) {
                answer[i] *= 2;
            } else if (currentNum >= 50 && currentNum % 2 == 0) {
                answer[i] /= 2;
            }
        }
        return answer;
    }
}