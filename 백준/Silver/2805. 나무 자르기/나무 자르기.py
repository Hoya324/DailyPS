from sys import stdin

n, m = map(int, stdin.readline().split())
tree = list(map(int, stdin.readline().split()))

start = 1
end = max(tree)
while start <= end:
    mid = (start + end) // 2

    gap = 0
    for i in tree:
        if i > mid:
            gap += i - mid

    if gap >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)