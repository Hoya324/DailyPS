import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

public class Main{
    public static int N, M;
    public static int [][] graph = new int[101][101];
    public static int [] dx = {-1, 1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > M || ny < 0 || ny > N) {
                    continue;
                }
                if (graph[ny][nx] == 0) {
                    continue;
                }
                if (graph[ny][nx] == 1) {
                    graph[ny][nx] = graph[y][x] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return graph[N - 1][M - 1];    
    }
    

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(scan.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());  
        

        //graph 구성
        for(int y = 0; y < N; y++){
            String map = scan.readLine();
            for(int x = 0; x < M; x++) {
                graph[y][x] = map.charAt(x) - '0'; 
            }
        }
        
        System.out.print(bfs(0, 0));
    }
}   