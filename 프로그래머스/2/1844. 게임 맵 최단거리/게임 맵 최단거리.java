import java.util.*;

class Solution {
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        return findShortestPath(maps, n, m);
    }
    
    private int findShortestPath(int[][] maps, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int pathLength = current[2];
            
            if (x == m - 1 && y == n - 1) {
                return pathLength;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (isInBounds(nextX, nextY, n, m) && !visited[nextY][nextX] && maps[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextX, nextY, pathLength + 1});
                }
            }
        }
        
        return -1; 
    }

    private boolean isInBounds(int x, int y, int n, int m) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
