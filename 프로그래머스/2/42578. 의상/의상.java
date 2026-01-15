import java.util.HashMap;

class Solution {
    
    private static final int NONE_SELECTED_CLOTH_COUNT = 1;
    private static final int ANY_CLOTH_NOT_SELECTED = 1;
    
    public int solution(String[][] clothes) {
        // 해시맵 초기화
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        for (String[] cloth: clothes) {
            String type = cloth[1];
            clothMap.put(type, clothMap.getOrDefault(type, 0) + 1);
        }
        
        // 종류의 수에 따라 1~종류 count 
        int answer = 1;
        for (int clothCount: clothMap.values()) {
            answer *= (clothCount + NONE_SELECTED_CLOTH_COUNT);
        }
        return answer - ANY_CLOTH_NOT_SELECTED;
    }
}