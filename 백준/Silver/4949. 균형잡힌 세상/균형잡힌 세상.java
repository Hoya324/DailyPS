import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static String solution(String word) {
        char nowChar;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length()-1; i++) {
            nowChar = word.charAt(i);
            if (nowChar == '(') {
                stack.push('(');
            }
            else if (nowChar == '[') {
                stack.push('[');
            }

            else if (nowChar == ')') {
                 if(!stack.empty() && stack.peek() == '(') {
                     stack.pop();
                 }
                 else {
                     return "no";
                 }
            }

            else if (nowChar == ']'){
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                }
                else {
                    return "no";
                }
            }

        }
        if (stack.empty()) {
            return "yes";
        }
        return "no";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String word = br.readLine();
            if (word.equals(".")) {
                break;
            }
            stringBuilder.append(solution(word)).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
