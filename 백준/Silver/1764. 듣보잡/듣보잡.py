from sys import stdin

n, m = map(int, stdin.readline().split())
s_n = set()
for _ in range(n):
    s_n.add(stdin.readline())

s_m = set()
for _ in range(m):
    s_m.add(stdin.readline())

result = s_n & s_m
print(len(result))

ans = []
for i in range(len(result)):
    ans.append(result.pop())

ans.sort()
print(''.join(ans))