import java.io.*;
import java.util.*;

public class Main{


	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
  
        int N = Integer.parseInt(scan.readLine());    
        String [] arr = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = scan.readLine();
        }

        Arrays.sort(arr);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append("\n");

        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}   