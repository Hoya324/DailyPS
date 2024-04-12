import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static Integer[] dp;
	static int[][] wire;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		int N = Integer.parseInt(bufferedReader.readLine());

		dp = new Integer[N];
		wire = new int[N][2];

		for(int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			wire[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			wire[i][1] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});


		// 어떤 전봇대 번호부터 시작하는가
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(findMaxLine(i), max);
		}

		// 전선 개수 - 쵀댓값 
		System.out.println(N - max);
	}


	static int findMaxLine(int N) {

		if(dp[N] == null) {

			dp[N] = 1;

			for(int i = N + 1; i < dp.length; i++) {

				// N이후의 A에서 B에 연결된 전기줄이 더 뒤일 때
				if(wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
					dp[N] = Math.max(dp[N], findMaxLine(i) + 1);
				}
			}
		}
		return dp[N];
	}

}