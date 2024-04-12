import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    static StringBuilder sb;
    static int [][] prefixSum;

    public static StringBuilder solve(StringTokenizer st) {
        int x1 = parseInt(st.nextToken());
        int y1 = parseInt(st.nextToken());
        int x2 = parseInt(st.nextToken());
        int y2 = parseInt(st.nextToken());

        int result = 0;
        for (int j = x1-1; j < x2; j++) {
            if (y1 < y2) {
                result += prefixSum[j][y2] - prefixSum[j][y1-1];
            }
            else {
                result += prefixSum[j][y2] - prefixSum[j][y2-1];
            }
        }
        sb.append(result).append("\n");

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(scan.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        prefixSum = new int[N][N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(scan.readLine());
            for (int j = 1; j < N+1; j++) {
                prefixSum[i][0] = 0;
                prefixSum[i][j] += prefixSum[i][j-1] + parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(scan.readLine());
            solve(st);
        }

        bw.write(sb.toString());
        bw.close();
        scan.close();
    }
}
