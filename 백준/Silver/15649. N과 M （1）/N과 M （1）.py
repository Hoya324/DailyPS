from itertools import permutations
from sys import stdin

N, M = map(int, stdin.readline().split())
nPr = []
for i in range(1, N+1):
    nPr.append(str(i))

# for a, b in list(permutations(nPr, 2)):
#     print(a, b)

print("\n".join(list(map(" ".join, list(permutations(nPr, M))))))