import sys
input = sys.stdin.readline

while True:
  n = int(input())
  if n == 0:
    break
  r = int((2*n) ** 0.5)
  array = [True] * (2*n + 1)
  for i in range(2, r + 1):
    if array[i] == True:
      for j in range(i+i, (2*n) + 1, i):
        array[j] = False
  
  prime_list = [i for i in range(n + 1, (2*n) + 1) if array[i] == True]
  print(len(prime_list))

