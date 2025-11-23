import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N, tScore, P;
    StringTokenizer st = new StringTokenizer(reader.readLine());
    
    N = Integer.parseInt(st.nextToken());
    tScore = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    if (N == 0) {
      System.out.print(1);
      return;
    }

    long[] scores = Arrays.stream(reader.readLine().split(" "))
      .map(Long::parseLong)
      .mapToLong(Long::longValue)
      .toArray();

    if(N == P && !(tScore > scores[N-1])) {
      System.out.print(-1);
      return;
    }

    int rank = 1;
    for (int a = 0; a < N; a++) {
      if(tScore < scores[a]) {
        rank++;
      } else {
        break;
      }
    }

    System.out.print(rank);
  }
}
