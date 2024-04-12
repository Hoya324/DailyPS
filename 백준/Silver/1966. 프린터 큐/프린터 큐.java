import java.io.*;
import java.util.*;

public class Main{
    
    
    
	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
    Queue<Integer> queue = new LinkedList<>();

    int N = Integer.parseInt(scan.readLine());    

    StringBuilder sb = new StringBuilder();
        
    for (int i = 0; i < N; i++) {
        
        StringTokenizer st = new StringTokenizer(scan.readLine());
        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(scan.readLine());
        for (int j = 0; j < num; j++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int importance = 9;
        int order = 1;
        while (importance > 0) {
            // 해당 중요도가 큐에 들어있을 때
            if (queue.contains(importance)) {
                // 해당하는 인덱스의 수가 맨 앞, 중요도가 가장 높음
                if (index == 0 && queue.peek() == importance) {
                    sb.append(order + "\n");
                    break;
                }    
                // 해당 인덱스의 수가 맨 앞, 중요도는 가장 높지 않음
                else if(index == 0 && queue.peek() != importance) {
                    // 위치 초기화
                    index = (queue.size() - 1);
                    queue.add(queue.remove());
                }                
                else if (index != 0 && queue.peek() == importance){
                    queue.remove();
                    // 해당 인덱스 위치 저장
                    index--;
                    // 순서
                    order++;                    
                    continue;
                }
                else {
                    // 중요도가 가장 높은 문서를 앞으로 옮기는 중
                    queue.add(queue.remove());
                    // 해당 인덱스 위치 저장
                    index--;
                }
                
                
            }
            // 테스크 케이스에 포함된 중요도 중 큰 순서대로 확인
            else {
                importance--;
            }
        }
        queue.clear();
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    }
}   