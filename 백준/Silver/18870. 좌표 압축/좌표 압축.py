from sys import stdin

n = int(input())
arr = list(map(int, stdin.readline().split()))
dic = {}
result = sorted(list(set(arr)))
for i in range(len(result)):
    dic[result[i]] = i


print(' '.join(str(dic[i]) for i in arr))