import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static Integer [][] dp; // 숫자가 0이상이므로 null 값으로 들어갔는지 아닌지 판단
	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		N = Integer.parseInt(bufferedReader.readLine());

		arr = new int[N][N];
		dp = new Integer [N][N];

		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dp[N-1][i] = arr[N-1][i];
		}

		System.out.println(findMax(0, 0));


	}

	static int findMax(int depth, int index) {
		if (depth == N - 1) {
			return dp[depth][index];
		}

		if (dp[depth][index] == null) {
			dp[depth][index] = Math.max(findMax(depth + 1, index), findMax(depth + 1, index + 1)) + arr[depth][index];
		}

		return dp[depth][index];
	}
}
