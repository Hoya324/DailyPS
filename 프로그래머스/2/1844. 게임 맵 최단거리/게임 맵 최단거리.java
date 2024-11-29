import java.util.*;

class PathInfo {
    private int x;
    private int y;
    private int pathLength;
    
    public PathInfo(int x, int y, int pathLength) {
        this.x = x;
        this.y = y;
        this.pathLength = pathLength;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getPathLength() {
        return this.pathLength;
    }
}

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
        Queue<PathInfo> queue = new LinkedList<>();
        queue.add(new PathInfo(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            PathInfo current = queue.poll();
            int x = current.getX();
            int y = current.getY();
            int pathLength = current.getPathLength();
            
            if (x == m - 1 && y == n - 1) {
                return pathLength;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (isInBounds(nextX, nextY, n, m) && !visited[nextY][nextX] && maps[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new PathInfo(nextX, nextY, pathLength + 1));
                }
            }
        }
        
        return -1;
    }

    private boolean isInBounds(int x, int y, int n, int m) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
