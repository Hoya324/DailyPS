import java.io.*;
import java.util.*;



public class Main{

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(scan.readLine());
        int [] arr = new int [N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(scan.readLine());
        }
        StringBuilder sb = new StringBuilder();
       
        Arrays.sort(arr);
        
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + "\n"); 
        }

        System.out.print(sb);

    }
}   