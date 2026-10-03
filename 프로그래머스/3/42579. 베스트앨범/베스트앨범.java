import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Long> genreTotal = new HashMap<>();
        Map<String, List<Integer>> genreSongs = new HashMap<>();

        // 1. 장르별 총 재생 횟수와 노래 고유 번호 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            genreTotal.put(
                genre,
                genreTotal.getOrDefault(genre, 0L) + plays[i]
            );

            genreSongs.computeIfAbsent(
                genre, key -> new ArrayList<>()
            ).add(i);
        }

        // 2. 총 재생 횟수가 많은 장르부터 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());

        sortedGenres.sort((a, b) ->
            Long.compare(genreTotal.get(b), genreTotal.get(a))
        );

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Integer> songs = genreSongs.get(genre);

            // 3. 재생 횟수 내림차순, 같으면 고유 번호 오름차순
            songs.sort((a, b) -> {
                int comparison = Integer.compare(plays[b], plays[a]);

                if (comparison == 0) {
                    return Integer.compare(a, b);
                }

                return comparison;
            });

            // 4. 장르별 최대 두 곡 선택
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i));
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}