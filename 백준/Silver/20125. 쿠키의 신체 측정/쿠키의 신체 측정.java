import java.io.*;

public class Main {

	private static final String COOKIE = "*";
	private static final String EMPTY_PLACE = "_";
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};

	private static String solution(String[][] map, int[] heartPoint) {
		int leftArm = calculateLength(map, heartPoint[0], heartPoint[1] - 1, dx[2], dy[2]);
		int rightArm = calculateLength(map, heartPoint[0], heartPoint[1] + 1, dx[3], dy[3]);
		int waist = calculateLength(map, heartPoint[0] + 1, heartPoint[1], dx[1], dy[1]);
		int leftLeg = calculateLength(map, heartPoint[0] + waist + 1, heartPoint[1] - 1, dx[1], dy[1]);
		int rightLeg = calculateLength(map, heartPoint[0] + waist + 1, heartPoint[1] + 1, dx[1], dy[1]);

		StringBuilder sb = new StringBuilder();
		sb.append(heartPoint[0] + 1).append(" ").append(heartPoint[1] + 1).append("\n");
		sb.append(leftArm)
			.append(" ")
			.append(rightArm)
			.append(" ")
			.append(waist)
			.append(" ")
			.append(leftLeg)
			.append(" ")
			.append(rightLeg);
		return sb.toString();
	}

	private static int calculateLength(String[][] map, int y, int x, int dx, int dy) {
		int length = 0;
		while (x >= 0 && y >= 0 && x < map[0].length && y < map.length && map[y][x].equals(COOKIE)) {
			length++;
			x += dx;
			y += dy;
		}
		return length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		int[] heartPoint = new int[2];
		String[][] map = new String[size][size];
		boolean isFirstCookie = true;

		for (int i = 0; i < size; i++) {
			String line = br.readLine();
			for (int j = 0; j < size; j++) {
				String currentCell = String.valueOf(line.charAt(j));
				if (currentCell.equals(COOKIE)) {
					if (isFirstCookie) {
						heartPoint[0] = i + 1;
						heartPoint[1] = j;
						isFirstCookie = false;
					}
				}
				map[i][j] = currentCell;
			}
		}

		resolve(solution(map, heartPoint));
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(answer);
			bw.flush();
		}
	}
}
