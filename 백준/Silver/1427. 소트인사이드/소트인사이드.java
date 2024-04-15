import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
 
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        
        String data = scan.readLine();
        ArrayList<Integer> arr = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < data.length(); i++) {
            arr.add(Character.getNumericValue(data.charAt(i)));
        }

        Collections.sort(arr, Collections.reverseOrder());

        for(int i: arr){
            sb.append(i);
        }

        System.out.println(sb);
    }   
    
}

