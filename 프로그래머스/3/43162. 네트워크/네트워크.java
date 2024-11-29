import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                countNetworkDFS(computers, visited, i);
                // countNetworkBFS(computers, visited, i);
            }
        }
        return result;
    }
    
    private void countNetworkBFS(int[][] computers, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(node);
        visited[node] = true;
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            
            for (int i = 0; i < visited.length; i++) {
                if (currentNode != i && !visited[i] && computers[currentNode][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    
    private void countNetworkDFS(int[][] computers, boolean[] visited, int node) {
        
        visited[node] = true;
        
        for (int i = 0; i < visited.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                countNetworkDFS(computers, visited, i);
            }
        }
    }
}