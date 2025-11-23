import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine());

    long result = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
    System.out.println(result);
  }
}
