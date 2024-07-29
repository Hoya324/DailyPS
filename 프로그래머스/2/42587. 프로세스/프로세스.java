import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Character> readyQueue = new LinkedList<>();
        Queue<Integer> prioritiesQueue = new LinkedList<>();
        int intA = (int) 'A';
        char target = (char) (intA + location);
        
        int[] maxPriorities = priorities.clone();
        Arrays.sort(maxPriorities);
        int prioritiesSize = priorities.length;
        
        for (int i = 0; i < prioritiesSize; i++) {
            readyQueue.add((char) (intA + i));
            prioritiesQueue.add(maxPriorities[prioritiesSize-i-1]);
        }
        
        
        Queue<Character> progressQueue = new LinkedList<>();
        while (!readyQueue.isEmpty()) {
            int maxProcessPriority = prioritiesQueue.peek();
            
            if (maxProcessPriority == getPriority(readyQueue.peek(), priorities)) {
                progressQueue.add(readyQueue.poll());
                prioritiesQueue.poll();
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