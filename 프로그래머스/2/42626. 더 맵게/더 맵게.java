import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
        for (int s : scoville) {
            scovilleQueue.add(s);
        }
        
        int answer = 0;     
        while (true) {
            int minScoville = scovilleQueue.poll();
            if (minScoville >= K) {
                break;
            } else if (scovilleQueue.size() == 0) {
                answer = -1;
                break;
            }
            
            int secondSmallScoville = scovilleQueue.peek();
            scovilleQueue.add(minScoville + (secondSmallScoville * 2));
            scovilleQueue.poll();
            answer++;
        }

        return answer;
    }
}