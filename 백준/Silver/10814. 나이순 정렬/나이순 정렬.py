import sys

N = int(sys.stdin.readline())
arr = []

for i in range(N):
    data = []
    year, name = map(str, sys.stdin.readline().split())
    data.append(int(year))
    data.append(name)
    arr.append(data)

arr.sort(key = lambda x:x[0])

for i in range(N):
    print(str(arr[i][0]) + " " + arr[i][1])