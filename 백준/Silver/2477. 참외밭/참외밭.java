import java.io.*;
import java.util.*;

public class Main {
	private final static int LINE_SIZE = 6;

	private static int solution(int K, List<Integer> directions, List<Integer> lengths) {
		int everyField = -1;

		int allLinesProduct = 0;
		for (int i = 0; i < LINE_SIZE; i++) {
			if (i == LINE_SIZE - 1) {
				int nowField = lengths.get(i) * lengths.get(0);
				allLinesProduct += nowField;
				if (everyField < nowField) {
					everyField = nowField;
				}
				break;
			}
			int nowField = lengths.get(i) * lengths.get(i+1);
			allLinesProduct += nowField;
			if (everyField < nowField) {
				everyField = nowField;
			}
		}

		int melonField = allLinesProduct - (2 * everyField);

		return melonField * K;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		List<Integer> directions = new ArrayList<>();
		List<Integer> lengths = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			directions.add(Integer.parseInt(st.nextToken()));
			lengths.add(Integer.parseInt(st.nextToken()));
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(K, directions, lengths)));
		bw.flush();
		bw.close();
	}
}