import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String ps = br.readLine();


            for (int j = 0; j < ps.length(); j++) {
                if (ps.charAt(j) == '(') {
                    stack.push('(');
                }
                else {
                    if (stack.empty()) {
                        stack.push('n');
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.empty()) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
            stack.clear();
        }
        System.out.println(sb);
    }
}
