import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> triangleSet = new HashSet<>();
        ArrayList<Integer> sides = new ArrayList<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstSide = Integer.parseInt(st.nextToken());
            int secondSide = Integer.parseInt(st.nextToken());
            int thirdSide = Integer.parseInt(st.nextToken());

            if (firstSide == 0 || secondSide == 0 || thirdSide == 0) {
                break;
            }
            sides.add(firstSide);
            sides.add(secondSide);
            sides.add(thirdSide);
            int maxSide = Collections.max(sides);

            sides.remove((Integer)maxSide);
            int leftTwoSideSum = sides.stream().mapToInt(side -> side).sum();

            if (maxSide >= leftTwoSideSum) {
                sb.append("Invalid").append('\n');
                continue;
            }

            triangleSet.add(firstSide);
            triangleSet.add(secondSide);
            triangleSet.add(thirdSide);
            int triangleSetSize = triangleSet.size();

            if (triangleSetSize == 1) {
                sb.append("Equilateral").append('\n');
            } else if (triangleSetSize == 2) {
                sb.append("Isosceles").append('\n');
            } else if (triangleSetSize == 3) {
                sb.append("Scalene").append('\n');
            }
            triangleSet.clear();
            sides.clear();
        }

        System.out.println(sb);
    }
}
