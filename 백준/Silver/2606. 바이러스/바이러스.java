import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static boolean [] visited;
    static ArrayList<ArrayList<Integer>> graph;
    

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        
        N = Integer.parseInt(scan.readLine()); 
        M = Integer.parseInt(scan.readLine());  
        
        graph = new ArrayList<ArrayList<Integer>>(N + 1);
        

        //graph 구성
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(scan.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }
        
        visited = new boolean [N+1];
       
        dfs(1);

        int count = 0;

        for (int i = 1; i < N+1; i++) {
            if (visited[i]) {
                count++;
            }
        }
        if (count >= 0) {
            count--;
            System.out.print(count);
        }
        else {
            System.out.print(0);
        }    
    }

    public static void dfs(int x) {
        visited[x] = true;
        for(int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }
    
}   