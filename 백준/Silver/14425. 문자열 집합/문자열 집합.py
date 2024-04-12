from sys import stdin

n, m = map(int, stdin.readline().split())

s1 = set()
result = 0

for _ in range(n):
  s1.add(input())

for _ in range(m):
  temp = input()
  if temp in s1:
    result += 1

print(result)
