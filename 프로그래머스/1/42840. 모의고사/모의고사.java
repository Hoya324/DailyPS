import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) scores[0]++;
            if (answers[i] == second[i % second.length]) scores[1]++;
            if (answers[i] == third[i % third.length]) scores[2]++;
        }
        
        int maxScore = Arrays.stream(scores).max().orElseThrow(NoSuchElementException::new);;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}