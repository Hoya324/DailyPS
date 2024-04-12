import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private String solve() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        StringTokenizer command;
        StringBuilder stringBuilder = new StringBuilder();

        int commandNumber = Integer.parseInt(bufferedReader.readLine());
        for (int count = 0; count < commandNumber; count++) {
            command = new StringTokenizer(bufferedReader.readLine());
            switch (command.nextToken()) {
                case "push_front":
                    deque.addFirst(command.nextToken());
                    break;

                case "push_back":
                    deque.add(command.nextToken());
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        stringBuilder.append("-1").append("\n");
                    } else {
                        stringBuilder.append(deque.pollFirst()).append("\n");
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        stringBuilder.append("-1").append("\n");
                    } else {
                        stringBuilder.append(deque.pollLast()).append("\n");
                    }
                    break;

                case "size":
                    stringBuilder.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        stringBuilder.append(1).append("\n");
                    } else {
                        stringBuilder.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        stringBuilder.append(-1).append("\n");
                        break;
                    }
                    stringBuilder.append(deque.peek()).append("\n");
                    ;
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        stringBuilder.append(-1).append("\n");
                        break;
                    }
                    stringBuilder.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        System.out.println(main.solve());
    }
}
