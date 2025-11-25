import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long total = Arrays.stream(works).sum();
        if (total <= n) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pq.add(w);

        for (int i = 0; i < n; i++) {
            int top = pq.poll();
            pq.add(top - 1);
        }

        long result = 0;
        for (int w : pq) result += (long) w * w;
        return result;
    }
}
