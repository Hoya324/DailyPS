import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<Integer> heap;

    public static void insert(int num) {
        
        heap.add(num);
        int end = heap.size() - 1;

        while (end > 1 && heap.get(end) < heap.get(end / 2)) {
            int tmp = heap.get(end / 2);
            heap.set(end / 2, num);
            heap.set(end, tmp);

            end /= 2;
        }
        
    }

    public static int del(){
        if (heap.size() <= 1) {
            return 0;
        }
        else {
            int min = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.set(heap.size() - 1, min);
            heap.remove(heap.size() - 1);

            int parent = 1;
            while (true){
                int child = parent * 2;

                // 자식 노드 중 더 큰 노드의 값으로 변경
                if ((child < heap.size() - 1) && (heap.get(child) > heap.get(child + 1))){
                    child += 1;
                } 
                    
                // 부모 노드가 자식 노드보다 크면 계속
                if ((child >= heap.size()) || heap.get(child) > heap.get(parent)){
                    break;
                }
                    
                int t1 = heap.get(child);
                int t2 = heap.get(parent);
                heap.set(child, t2);
                heap.set(parent, t1);
                parent = child;
            }
            return min;
        }
    }

    public static void main(String[] args) throws IOException {
 
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        heap = new ArrayList<Integer>();
        heap.add(0);
        int n = Integer.parseInt(scan.readLine());

        for (int i = 0; i < n; i++){
            int data = Integer.parseInt(scan.readLine());
            if (data != 0) {
                insert(data);
            }
            else if (data == 0) {
                int a = del();
                sb.append(a).append("\n");
            }
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }
}