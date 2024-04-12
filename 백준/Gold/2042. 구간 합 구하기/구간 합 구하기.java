import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static long[] tree, arr;

    // 구간 합 트리, start: 시작 인덱스, end: 끝 인덱스
    public static long init (int start, int end, int node) {
        // 리프 노드일 때 저장
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // 구간 합을 구하는 함수, left와 right는 구하고자하는 범위
    public static long sum(int start, int end, int node, int left, int right) {
        // 범위를 벗어난 경우
        if (left > end || right < start) {
            return 0;
        }

        // 범위 안에 있는 경우
        if (left <= start && right >= end) {
            return tree[node];
        } 

        // (중간과정) 두 부분으로 나누어 합을 구하기
        int mid = (start + end) / 2; // 하위 노드로 나누어짐
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

        // 수정하는 함수, index: 수정하고자하는 값의 인덱스, diff: 수정할 차이값
        public static void update(int start, int end, int node, int index, long diff) {
            //범위 밖에 있는 경우
            if (index > end || index < start) {
                return;
            }
            // 범위 안에 있는 경우, 하위 노드로 내려가면서 다른 원소도 갱신
            tree[node] += diff;
            if (start == end) {
                return;
            } 

            int mid = (start + end) / 2;
            update(start, mid, node*2, index, diff);
            update(mid + 1, end, node*2 + 1, index, diff);
        }        
    
    
	public static void main(String[] args) throws IOException{

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(scan.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 배열 설정
    arr = new long [N + 1];    
    // 배열 초기화
    for (int i = 1; i < N + 1; i++) {
        arr[i] = Long.parseLong(scan.readLine());
    } 

    // 트리 생성
    tree = new long[N*4];
    init(1, N, 1);

    StringBuilder sb = new StringBuilder();
        
    for (int i = 0; i < M + K; i++) {
            // a, b, c 값 받기
			st = new StringTokenizer(scan.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				long diff = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, diff);
			} 
            else if (a == 2) {
				sb.append(sum(1, N, 1, b, (int) c) + "\n");
			}
		}

		bw.write(sb.toString());
        
		bw.flush();
		bw.close();
    }
}   