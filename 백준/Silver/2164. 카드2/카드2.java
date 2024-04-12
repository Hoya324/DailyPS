import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private int solve() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int LastCardNumber = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int cardNumber = 1; cardNumber < LastCardNumber + 1; cardNumber++) {
            deque.add(cardNumber);
        }

        while (deque.size() != 1) {
            deque.pop();
            deque.add(deque.peek());
            deque.pop();
        }
        return deque.peek();
    }

    public static void main(String[] args) throws IOException {
        Main cardTwo = new Main();
        System.out.println(cardTwo.solve());
    }
}
