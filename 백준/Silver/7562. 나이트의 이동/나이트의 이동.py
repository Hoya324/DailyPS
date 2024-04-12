from sys import stdin
from collections import deque


def bfs(n, startY, startX, endY, endX, visited):
    dr = ((2, 1), (1, 2), (-2, 1), (-1, 2), (-2, -1), (-1, -2), (2, -1), (1, -2))
    dq = deque()

    dq.append((startY, startX))

    if startX == endX and startY == endY:
        return 0
    
    while dq:
        y, x = dq.popleft()

        for dy, dx in dr:
            ny = y + dy
            nx = x + dx

            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            
            if visited[ny][nx] == 0:
                visited[ny][nx] = visited[y][x] + 1
                dq.append((ny, nx))

            if ny == endY and nx == endX:
                return visited[ny][nx]



t = int(input())
for _ in range(t):
    w = int(input())
    startY, startX = map(int, stdin.readline().split())
    endY, endX = map(int, stdin.readline().split())
    visited = [[0] * w for _ in range(w)]
    print(bfs(w, startY, startX, endY, endX, visited))