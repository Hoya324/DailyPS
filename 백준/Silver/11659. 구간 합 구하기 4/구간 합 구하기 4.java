import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(scan.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        st = new StringTokenizer(scan.readLine());
        int [] prefixSum = new int[N+1];

        prefixSum[0] = 0;

        for (int i = 0; i < N; i++) {
            prefixSum[i+1] += prefixSum[i] + parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(scan.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            int result = prefixSum[b] - prefixSum[a-1];

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}