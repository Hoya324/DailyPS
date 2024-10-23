import java.io.*;
import java.util.*;

enum GameType {
	윷놀이("Y", 2),
	그림_찾기("F", 3),
	원카드("O", 4);

	private final String type;
	private final int peopleCount;

	GameType(final String type, final int peopleCount) {
		this.type = type;
		this.peopleCount = peopleCount;
	}

	public static int getPersonCount(String currentType) {
		GameType gameType = Arrays.stream(GameType.values())
			.filter((value) -> value.type.equals(currentType))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("없는 gametype 입니다."));

		return gameType.peopleCount;
	}
}

public class Main {


	private static int solution(List<String> people, int personCount) {
		Set<String> alreadyPlayedPeople = new HashSet<>();
		int chargedCount = 1;
		int result = 0;

		for (String person : people) {
			if (alreadyPlayedPeople.contains(person)) {
				continue;
			}

			chargedCount++;
			alreadyPlayedPeople.add(person);

			if (chargedCount == personCount) {
				result++;
				chargedCount = 1;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int count = Integer.parseInt(st.nextToken());
		String gameType = st.nextToken();
		int personCount = GameType.getPersonCount(gameType);

		ArrayList<String> people = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			people.add(br.readLine());
		}

		resolve(solution(people, personCount));
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}
