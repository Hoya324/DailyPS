import java.io.*;
import java.util.*;

public class Main{
    static boolean [][] chess;
    static int min = 64;

   

	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(scan.readLine());
  
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        chess = new boolean [N][M];
        
        for (int j = 0; j < N; j++) {
            String data = scan.readLine();
            for (int i = 0; i < M; i++) {
                if (data.charAt(i) == 'W') chess[j][i] = true;
                else if (data.charAt(i) == 'B') chess[j][i] = false;
            }
        }

        
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                countBoard(j, i);
            }
        }

        System.out.print(min);
        
        
    }
    
     // 모든 경우의 수를 처음 시작하는 색을 기준으로 나누어 계산하고 더 적은 수를 기록
    public static void countBoard (int x, int y) {
        int xEnd = x + 8;
        int yEnd = y + 8;
        int count = 0;

        boolean firstBorad = chess[y][x];

        for (int i = y; i < yEnd; i++) {
            for (int j = x; j < xEnd; j++) {
                if (chess[i][j] != firstBorad) {
                    count++;
                }

                // 다음 칸은 다른 색이므로
                firstBorad = (!firstBorad);                                
            }
            firstBorad = (!firstBorad);    
        }

        count = Math.min(count, 64 - count);
		min = Math.min(min, count);
    }
}   

