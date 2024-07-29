import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> progressesList = new ArrayList<>();
        List<Integer> speedsList = new ArrayList<>();
        int progressesLength = progresses.length;
        
        for (int i = 0; i < progressesLength; i++) {
            progressesList.add(progresses[i]);
            speedsList.add(speeds[i]);
        }
    

        List<Integer> answerList = new ArrayList<>();
        while(!progressesList.isEmpty()) {
            int count = 0;
            for (int i = 0; i < progressesList.size(); i++) {
                int nextProgress = progressesList.get(i) + speedsList.get(i);
                progressesList.set(i, nextProgress);
            }
            while (!progressesList.isEmpty() && progressesList.get(0) >= 100) {
                progressesList.remove(0);
                speedsList.remove(0);
                count++;
            }
            if (count > 0) {
                answerList.add(count);
            }
        }
        int[] answer = answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer;
    }
}