import java.util.*;

class Solution {
    
    public String solution(String s) {
        int[] raw = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        
        StringBuilder sb = new StringBuilder();
        sb.append(raw[0]);
        sb.append(" ");
        sb.append(raw[raw.length - 1]);
        return sb.toString();
    }
}
