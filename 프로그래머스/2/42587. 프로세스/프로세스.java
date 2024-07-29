import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Character> readyQueue = new LinkedList<>();
        int[] maxPriorities = priorities.clone();
        int intA = (int) 'A';
        char target = (char) (intA + location);
        for (int i = 0; i < priorities.length; i++) {
            readyQueue.add((char) (intA + i));
        }
        
        Queue<Character> progressQueue = new LinkedList<>();
        while (!readyQueue.isEmpty()) {
            int maxProcessPriority = 0;
            int maxProcessPriorityIndex = -1;
            for (int index = 0; index < priorities.length; index++) {
                int currentPrority = maxPriorities[index];
                if (maxProcessPriority <= currentPrority) {
                    maxProcessPriority = currentPrority;
                    maxProcessPriorityIndex = index;
                }
            }
        
            if (maxProcessPriority == getPriority(readyQueue.peek(), priorities)) {
                progressQueue.add(readyQueue.poll());
                maxPriorities[maxProcessPriorityIndex] = 0;
                continue;
            }
            
            readyQueue.add(readyQueue.poll());
        }
        
        
        int answer = 0;
        while (!progressQueue.isEmpty()) {
            answer++;
            char currentProcess = progressQueue.poll();
            if (currentProcess == target) {
                break;
            }            
        }
        return answer;
    }
    
    private int getPriority(char process, int[] priorities) {
        int intA = (int) 'A';
        return priorities[(int) process - intA];
    }
}