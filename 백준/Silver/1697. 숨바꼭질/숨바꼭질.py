from sys import stdin
from collections import deque

    
def bfs(N, K):
    dq = deque()
    
    dq.append(N)
    visited[N] = True
    count = 0

    while dq:
        count += 1
        for _ in range(len(dq)):
            data = dq.popleft()
          
            if data - 1 >= 0 and visited[data - 1] == False:
                visited[data - 1] = True
                if data - 1 == K:
                    return count
                else:
                    dq.append(data - 1)
                    
            if data + 1 <= 100000 and visited[data + 1] == False:
                visited[data + 1] = True
                if data + 1 == K:
                    return count
                else:
                    dq.append(data + 1)
                    
            if data*2 <= 100000 and visited[data * 2] == False:
                visited[data * 2] = True
                if data * 2 == K:
                    return count
                else:
                    dq.append(data * 2)
    return count
            

N, K = map(int, stdin.readline().split())
visited = [False] * 100001
if N == K:
    print(0)
else:
    print(bfs(N, K))