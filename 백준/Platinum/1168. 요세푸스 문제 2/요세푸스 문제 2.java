import java.io.*;
import java.util.*;

public class Main{
    static int [] tree;
    //트리 초기화
    public static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = 1;
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, 2*node) + init(mid + 1, end, 2*node + 1);
    }

    // 트리 정보 수정
    public static int update(int start, int end, int node, int del) {
        // 트리를 1로 모두 초기화 했기 때문에 리프 노드의 상위 노드 경로를 지나며 개수 줄임
        tree[node]--;
        if (start == end) {
            return 0;
        }
        else {
            int mid = (start + end) / 2;
            if (del <= mid){
                // 지워질 부분이 포함될 때
                return update(start, mid, 2*node, del);
            }
            else {
                return update(mid + 1, end, 2*node + 1, del);
            }
        }
    }
    // 다음 순서에 해당하는 번호 받아오기
    public static int query(int start, int end, int node, int order) {
        // start와 end의 위치가 일치하면 번호를 반환
        if (start == end) { 
            return start;
        }
        int mid = (start + end) / 2;
        // 순서가 하위 노드의 시작보다 작을 때
        if (order <= tree[2*node]) {
            return query(start, mid, 2*node, order);
        }
        else {
            return query(mid + 1, end, 2*node + 1, order - tree[2*node]);
        }
    }
    
    
	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(scan.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    tree = new int[N * 4];
    init(1, N, 1);

    int index = 1;
    StringBuilder sb = new StringBuilder("<");
        
    for (int i = 0; i < N; i++) {
        index += K - 1;
        // 사람 수
        int size = N - i; 

        if (index % size == 0) {
            index = size;
        }
        else if (index > size) {
            index %= size;
        }

        // 세그먼트 트리에서의 순서 찾기
        int num = query(1, N, 1, index);
        // 트리에서 해당 숫자 삭제
        update(1, N, 1, num);  

        if (i == N - 1) {
            sb.append(num + ">");
        }
        else {
            sb.append(num + ", ");
        }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    }
}   