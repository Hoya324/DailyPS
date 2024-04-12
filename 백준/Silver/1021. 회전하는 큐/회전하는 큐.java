import java.io.*;
import java.util.*;

public class Main{

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        
        
        StringTokenizer st = new StringTokenizer(scan.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        
        int count = 0;
        String [] arr = scan.readLine().split(" ");
        
        for (int i = 0; i < M; i++) {
            
            int size = deque.size();
            int index = deque.indexOf(Integer.parseInt(arr[i]));
            float mid = size / 2; 
            if(index <= mid) {
				for(int j = 0; j < index; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {
				for(int j = 0; j < size - index; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();            
        }
        
        System.out.print(count);
    }
}   