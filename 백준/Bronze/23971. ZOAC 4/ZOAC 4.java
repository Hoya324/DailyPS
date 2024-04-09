import java.io.*;
import java.util.*;

public class Main {

    private static final int SPACE_OF_ONE_PERSON = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        double N = Double.parseDouble(st.nextToken());
        double M = Double.parseDouble(st.nextToken());

        int personPerRow = (int) Math.ceil(H / (N + SPACE_OF_ONE_PERSON));
        int personPerCol = (int) Math.ceil(W / (M + SPACE_OF_ONE_PERSON));
        int totalPersonCount = personPerRow * personPerCol;

        System.out.println(totalPersonCount);
    }
}
