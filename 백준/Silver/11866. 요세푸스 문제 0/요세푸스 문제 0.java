import java.io.*;
import java.util.*;

public class Main{

    
    
	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(scan.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    StringBuilder sb = new StringBuilder("<");
    Queue<Integer> queue = new LinkedList<>();
        

    for (int i = 0; i < N; i++) {
        queue.add(i + 1);
    }

    for (int i = 0; i < N; i++) {
        for (int j = 1; j < K; j++) {
            queue.add(queue.peek());
            queue.remove();
        }
        if (i == N-1) {
            sb.append(queue.peek() + ">");
            break;
        }
        sb.append(queue.peek() + ", ");
        queue.remove();
    }

    System.out.print(sb);
    }
}   