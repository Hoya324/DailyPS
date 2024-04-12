import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer> units = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			units.add(Integer.parseInt(bf.readLine()));
		}

		int count = N - 1;
		int result = 0;
		while (K > 0 && count >= 0) {
			if (K < units.get(count)) {
				count--;
				continue;
			}

			if ((K - units.get(count)) >= 0) {
				K -= units.get(count);
				result++;
			}
		}

		System.out.println(result);
	}
}
