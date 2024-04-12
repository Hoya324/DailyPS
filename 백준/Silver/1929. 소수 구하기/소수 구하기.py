import sys
M, N = map(int, sys.stdin.readline().split())

#에라토스테네스의 체 초기화: N개의 요소에 True 설정(소수로 간주)
sieve = [True] * (N + 1)
r = int(N ** 0.5)
sieve[1] = False

for i in range(2, r + 1):
  if sieve[i] == True:
    for j in range(i+i, N + 1, i):
      sieve[j] = False

for i in range(M, N + 1):
  if sieve[i] == True:
    print(i)
