import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static boolean[] visited = new boolean[N];
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(scan.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken()); 
        graph = new ArrayList<ArrayList<Integer>>(N + 1);
        

        //graph 구성
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(scan.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        visited = new boolean[N+1];

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }

    public static void dfs(int x) {
        visited[x] = true;
        sb.append(x + " ");
        for(int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start + " ");
        while(!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    sb.append(y + " ");
                }
            }
            
        }
    }
    
}   