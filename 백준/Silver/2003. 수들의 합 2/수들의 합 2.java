import java.io.*;
import java.util.*;

public class Main {

	private static int solution(int size, int target, int[] sequence) {
		int result = 0;
		for (int startIndex = 0; startIndex < size; startIndex++) {
			int tryNumber = 0;
			for (int currentIndex = startIndex; currentIndex < size; currentIndex++) {
				tryNumber += sequence[currentIndex];
				if (tryNumber == target) {
					result++;
					break;
				} else if (tryNumber > target) {
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] sequence = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		bw.write(String.valueOf(solution(size, target, sequence)));
		bw.flush();
		bw.close();
	}
}