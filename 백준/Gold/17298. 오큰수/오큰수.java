import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    
    
	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(scan.readLine());
    
    // 배열 생성
    StringTokenizer st = new StringTokenizer(scan.readLine());
    int [] arr = new int[N];
    int [] res = new int[N];
        
    for (int i = 0; i< N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
    }
    
    Stack<Integer> index = new Stack<Integer>(); // 비교를 위한 배열 인덱스로서 스택 사용
        
    index.push(0); // 가장 초기 비교값
        
    for (int i = 1; i < N; i++) {
        // 오른쪽으로 진행하면서 더 큰 수가 나올 때 
        while (!index.empty() && arr[index.peek()] < arr[i]) { 
            // 오큰수를 만나는 경우
            res[index.pop()] = arr[i];          
        }       
        index.push(i);  

        if (index.empty()) {
            index.push(i);
        }
    } 
        
    while (!index.empty()) {
        res[index.pop()] = -1;  
    }

     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N ; i++) {
            bw.write(res[i] + " "); 
    }
    bw.write("\n");
    bw.flush();
    }
}   