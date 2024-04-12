import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int target;
        int currentNumber = 1;

        for (int i = 0; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            while (currentNumber <= target) {
                deque.add(currentNumber);
                currentNumber++;
                stringBuilder.append("+").append("\n");
            }

            if (deque.peekLast() == target) {
                deque.removeLast();
                stringBuilder.append("-").append("\n");
            }
            else if (currentNumber > n) {
                break;
            }
        }

        if (!deque.isEmpty()) {
            System.out.println("NO");
        }
        else {
            System.out.println(stringBuilder.toString());
        }
    }
}
