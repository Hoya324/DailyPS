import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

 		int N = Integer.parseInt(bufferedReader.readLine());

		int [] dp = new int[N + 1];
		int [] stairs = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(bufferedReader.readLine());
		}

		dp[1] = stairs[1];

		if (N >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		// 3번째 계단을 오르는 방법이 2칸 + 1칸 또는 뛰어넘은 후 2칸
		for (int i = 3; i < N + 1; i++) {
			dp[i] = Math.max(stairs[i - 1] + dp[i - 3], dp[i-2]) + stairs[i];
		}

		System.out.println(dp[N]);

	}

}
