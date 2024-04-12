def dp(N):
    if N < 4:
        return 1

    else:
        visited[0], visited[1] , visited[2], visited[3] = 0, 1, 1, 1
        for i in range(4, N + 1):
            visited[i] = visited[i - 3] + visited[i - 2]

        return visited[N]

t = int(input())

for _ in range(t):
    N = int(input())
    visited = [0] * (N+1)
    
    print(dp(N))