from sys import stdin
from collections import deque


def tomato(m, n, h):
    dr = [[-1, 0, 0], [1, 0, 0], [0, -1, 0], [0, 1, 0], [0, 0, -1], [0, 0, 1]]
    
    change = deque()
    for z in range(h):
        for y in range(n):
            for x in range(m):
                
                
                if map[z][y][x] == 1:
                    change.append([z, y, x])

    while change:
        data = change.popleft()
        z = data[0]
        y = data[1]
        x = data[2]        
            
        for dz, dy, dx in dr:
            nz = z + dz
            ny = y + dy
            nx = x + dx
            
            if nx < 0 or ny < 0 or nz < 0 or nx >= m or ny >= n or nz >= h:
                continue
                
            if map[nz][ny][nx] == -1:
                continue
                
            if map[nz][ny][nx] == 0:
                map[nz][ny][nx] = map[z][y][x] + 1
                change.append([nz, ny, nx])
                    


m, n, h = map(int, stdin.readline().split())
map = [[list(map(int, stdin.readline().split())) for i in range(n)] for j in range(h)]

tomato(m, n, h)

Max = 0
a = 0
for i in range(h):
    for j in range(n):
        if Max < max(map[i][j]):
            Max = max(map[i][j])
        if 0 in map[i][j]:
            a += 1
            break
        
if a > 0:
    print(-1)
else:
    print(Max - 1)