import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
 
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(scan.readLine());
        ArrayList<Integer> arr = new ArrayList<>(n+1);

        if(n < 3){
            System.out.println(n);
        }
        else{
            arr.add(0);
            arr.add(1);
            arr.add(2);
            for(int i = 3; i <= n; i++){
                arr.add((arr.get(i - 1) + arr.get(i - 2)) % 15746);
            }
            System.out.println(arr.get(n));
        }
    }   
}