import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(scan.readLine());
    int [][] buildList = new int[N][2];
        
    for (int i = 0; i < N; i++){
        StringTokenizer st = new StringTokenizer(scan.readLine());
        buildList[i][0] = Integer.parseInt(st.nextToken());
        buildList[i][1] = Integer.parseInt(st.nextToken());
    }
        
    for (int j = 0; j < N; j++) {
        int grade = 1;
        for (int i = 0; i < N; i++) {
            if (buildList[i][0] > buildList[j][0] && buildList[i][1] > buildList[j][1]) { // 둘 다 작은 경우
                grade++; 
            }
        }
        System.out.print(grade + " ");
    }
    
    }
}