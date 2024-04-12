import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(scan.readLine());
    int [] stack = new int[K];
    int index = 0;
        
    for(int i = 0; i < K; i++) {
        StringTokenizer st = new StringTokenizer(scan.readLine());
        int data = Integer.parseInt(st.nextToken());
        
        if (data == 0) {
            index--;
            stack[index] = 0;
        }
        else {
            stack[index] = data;
            index++;
        }
    }
    int total = 0;
    for (int i = 0; i < index; i++) {
        total += stack[i];
    }
    System.out.print(total);

    }
}   