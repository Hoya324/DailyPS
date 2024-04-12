from sys import stdin
from collections import deque




def bfs(graph, start, visited):
    dq = deque()
    dq.append(start)
    visited[start] = 1
    
    while dq:
        k = dq.popleft()
        for i in graph[k]:
            if visited[i] == 0:
                visited[i] = visited[k] * (-1)
                dq.append(i)
            elif visited[i] == visited[k] * (-1):
                continue
            elif visited[i] == visited[k]:
                return "NO"

  
        if not dq:
            for i in range(len(visited)):
                if visited[i] == 0:
                    dq.append(i)
                    visited[i] = 1
                    break
        
    return "YES"
        

t = int(input())
for _ in range(t):
    v, e = map(int, stdin.readline().split())
    graph = [[] for _ in range(v+1)]
    for _ in range(e):
        a, b = map(int, stdin.readline().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1, v + 1):
        graph[i].sort()

    visited = [0] * (v+1)
    visited[0] = 111
    print(bfs(graph, 1, visited))