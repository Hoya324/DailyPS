import sys
N, *P = map(int, sys.stdin.read().split())
P.sort()
result = 0
count = 1
for _ in range(N):
    for i in P[:count]:
        result += i    
    count += 1
    
    
print(result)  