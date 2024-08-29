import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static int [] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine());
		arr = new int [N];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(bufferedReader.readLine());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			if (binarySearch(Integer.parseInt(stringTokenizer.nextToken())) >= 0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.print(sb);
	}


	private static int binarySearch (int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] > target) {
				end = mid - 1;
			}

			else if (arr[mid] < target) {
				start = mid + 1;
			}

			else {
				return mid;
			}
		}

		return -1;
	}
}   