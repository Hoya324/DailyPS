import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine());

            List<String> teams = new ArrayList<>();
            Map<String, Integer> teamCount = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String team = st.nextToken();
                teams.add(team);
                teamCount.put(team, teamCount.getOrDefault(team, 0) + 1);
            }

            Set<String> valid = new HashSet<>();
            for (String t : teamCount.keySet()) {
                if (teamCount.get(t) == 6) valid.add(t);
            }

            Map<String, Integer> scoreSum = new HashMap<>();
            Map<String, Integer> fifthScore = new HashMap<>();
            Map<String, Integer> rankCount = new HashMap<>();

            int score = 1;

            for (String team : teams) {
                if (!valid.contains(team)) {
                    continue;
                }

                rankCount.put(team, rankCount.getOrDefault(team, 0) + 1);

                if (rankCount.get(team) <= 4) {
                    scoreSum.put(team, scoreSum.getOrDefault(team, 0) + score);
                }

                if (rankCount.get(team) == 5) {
                    fifthScore.put(team, score);
                }

                score++;
            }

            List<String> validTeams = new ArrayList<>(valid);

            validTeams.sort((a, b) -> {
                int diff = scoreSum.get(a) - scoreSum.get(b);
                if (diff != 0) return diff;
                return fifthScore.get(a) - fifthScore.get(b);
            });

            System.out.println(validTeams.get(0));
        }
    }
}
