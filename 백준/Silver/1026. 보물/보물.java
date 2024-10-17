import java.io.*;
import java.util.*;

public class Main {

	private static int solution(int N, int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int result = 0;
		int reverseIdx = N - 1;
		for (int idx = 0; idx < N; idx++) {
			int BIndex = reverseIdx - idx;
			result += A[idx] * B[BIndex];
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] B = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		resolve(solution(N, A, B));
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}
