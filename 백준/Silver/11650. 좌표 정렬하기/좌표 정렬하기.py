from sys import stdin

N = int(stdin.readline())

arr = []
for i in range(N):
    a = list(map(int, stdin.readline().split()))
    arr.append(a)

arr.sort()
for i in range(N):
    print(arr[i][0], arr[i][1])
