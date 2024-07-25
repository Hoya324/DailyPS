import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> checkMap = new HashMap<>();
        for (String p : participant) {
            checkMap.put(p, checkMap.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            checkMap.put(c, checkMap.get(c) - 1);
        }
        
        return checkMap.keySet().stream()
            .filter((key) -> checkMap.get(key) != 0)
            .findFirst()
            .orElse("값이 없습니다.");
    }
}