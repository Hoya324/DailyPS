from sys import stdin
from collections import deque


def fish(y, x, size):
    distance = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    
    dq = deque()
    dq.append((y, x))

    visited[y][x] = True

    temp = []

    while dq:
            
        cy, cx = dq.popleft()
        
        for dy, dx in dr:
            ny = cy + dy
            nx = cx + dx

            if 0 <= ny < n and 0 <= nx < n and visited[ny][nx] == False:

                if map[ny][nx] <= size:
                    dq.append((ny, nx))
                    
                    visited[ny][nx] = True
                    
                    distance[ny][nx] = distance[cy][cx] + 1
                    
                    if map[ny][nx] < size and map[ny][nx] != 0:
                        temp.append((ny, nx, distance[ny][nx]))

    return sorted(temp, key=lambda x : (-x[2], -x[0], -x[1]))


    

n = int(input())
map = [list(map(int, stdin.readline().split())) for _ in range(n)]

dr = [[-1, 0], [0, -1], [0, 1], [1, 0]]
x, y, size = 0, 0, 2

for j in range(n):
        for i in range(n):
            if map[j][i] == 9:
                y, x = j, i

count = 0
result = 0

while True:
    prey = fish(y, x, size)
    
    if len(prey) == 0:
        break
        
    ny, nx, dist = prey.pop()
    
    result += dist
    map[y][x], map[ny][nx] = 0, 0
    
    y, x = ny, nx
    count += 1
    
    if count == size:
        size += 1
        count = 0

        
print(result)
