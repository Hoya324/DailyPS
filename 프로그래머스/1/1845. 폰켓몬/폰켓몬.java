import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> monsterTypeSet = new HashSet<>();
        
        for (int i : nums) {
            monsterTypeSet.add(i);
        }
        
        int halfN = nums.length / 2;
        int monsterTypeSize = monsterTypeSet.size();
        
        if (halfN > monsterTypeSize) {
            return monsterTypeSize;
        }
        return halfN;
    }
}