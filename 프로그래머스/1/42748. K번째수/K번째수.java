import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandsSize = commands.length;
        int[] answer = new int[commandsSize];
        
        for (int i = 0; i < commandsSize; i++) {
            int[] command = commands[i];
            int[] targetArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(targetArray);
            answer[i] = targetArray[command[2]-1];
        }
        
        return answer;
    }
}