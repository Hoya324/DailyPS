import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	private static final char LEFT_TAG = '<';
	private static final char RIGHT_TAG = '>';
	private static final char GAP = ' ';

	private static String solution(String sentence) {
		boolean isActivated = true;
		StringBuilder result = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();

		for (int index = 0; index < sentence.length(); index++) {
			char currentUnit = sentence.charAt(index);
			if (currentUnit == LEFT_TAG) {
				while (isActivated && !stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(currentUnit);
				isActivated = false;
				continue;
			}

			if (currentUnit == RIGHT_TAG) {
				isActivated = true;
				result.append(currentUnit);
				continue;
			}

			if (currentUnit == GAP) {
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(currentUnit);
				continue;
			}

			if (isActivated) {
				stack.push(currentUnit);
			} else {
				result.append(currentUnit);
			}
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(solution(br.readLine()));
		bw.flush();
		bw.close();
	}
}