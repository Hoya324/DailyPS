import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        List<String> brackets = new ArrayList<>(Arrays.asList(s.split("")));
        
        for (String bracket : brackets) {
            if (bracket.equals(")")) {
                if (count == 0) {
                    count--;
                    break;
                }
                count--;
            }
            if (bracket.equals("(")) {
                count++;
            }
        }
        if (count == 0) {
            return answer;
        } 
        answer = false;
        return answer;
    }
}