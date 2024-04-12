from sys import stdin
from collections import deque


def tomato(m,n):
    dr = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    
    change = deque()
    for y in range(n):
        for x in range(m):
            
            if map[y][x] == 1:
                change.append([y, x])

    while change:
        data = change.popleft()
        y = data[0]
        x = data[1]
            
        for ddx, ddy in dr:
            nx = x + ddx
            ny = y + ddy
            
            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
                
            if map[ny][nx] == -1:
                continue
                
            if map[ny][nx] == 0:
                map[ny][nx] = map[y][x] + 1
                change.append([ny, nx])
                    


m, n = map(int, stdin.readline().split())
map = [list(map(int, stdin.readline().split())) for _ in range(n)]

tomato(m, n)

Max = 0
a = 0
for i in range(n):
    if Max < max(map[i]):
        Max = max(map[i])
    if 0 in map[i]:
        a += 1
        break
        
if a > 0:
    print(-1)
else:
    print(Max - 1)