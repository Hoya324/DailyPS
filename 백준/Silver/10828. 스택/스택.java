import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static Stack<Integer>stack = new Stack<>();

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void command(StringTokenizer st) {

        switch (st.nextToken()) {
            case "push":
                stack.push(Integer.parseInt(st.nextToken()));
                break;

            case "pop":
                if (stack.empty()) {
                    stringBuilder.append("-1").append("\n");
                }
                else {
                    stringBuilder.append(stack.pop()).append("\n");;
                }
                break;

            case "size":
                stringBuilder.append(stack.size()).append("\n");;
                break;

            case "empty":
                if (stack.empty()) {
                    stringBuilder.append(1).append("\n");;
                }
                else {
                    stringBuilder.append(0).append("\n");;
                }
                break;
            case "top":
                if (stack.empty()) {
                    stringBuilder.append(-1).append("\n");;
                    break;
                }
                stringBuilder.append(stack.peek()).append("\n");;
                break;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            command(st);
        }

        System.out.println(stringBuilder);
    }
}
