import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) {
                result.add(arr[i]);
                continue;
            }
        }
        answer = result.stream().mapToInt(i -> i)
                .toArray();
        return answer;
    }
}