from sys import stdin
from collections import deque

def bfs(n, m, startY, startX, iscrash, visited, map):
    dr = ((1, 0), (-1, 0), (0, 1), (0, -1))
    dq = deque()  

    dq.append((startY, startX, iscrash))
    visited[startY][startX][iscrash] = 1

    while dq:
        y, x, iscrash = dq.popleft()

        if y == n - 1 and x == m - 1:
            return visited[y][x][iscrash]
        
        for dy, dx in dr:
            nx = x + dx
            ny = y + dy

            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue

            # 정상 이동
            if map[ny][nx] == 0 and visited[ny][nx][iscrash] == 0:
                dq.append((ny, nx, iscrash))
                visited[ny][nx][iscrash] = visited[y][x][iscrash] + 1
               
            # 벽을 부술 때(한번만 가능)
            if map[ny][nx] == 1 and iscrash == 0:
                dq.append((ny, nx, iscrash + 1))
                visited[ny][nx][iscrash + 1] = visited[y][x][iscrash] + 1
                
    return -1
            
            
n, m = map(int, stdin.readline().split())

map = [list(map(int, stdin.readline().rstrip())) for _ in range(n)]
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]

print(bfs(n, m, 0, 0, 0, visited, map))
