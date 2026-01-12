import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 스택 초기화
        Deque<Character> stack = new LinkedList<>();
        
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.pollLast();
                continue;
            }
            stack.addLast(c);
        }

        int answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}