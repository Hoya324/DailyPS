from sys import stdin

K, N = map(int, stdin.readline().split())
lan = list(map(int, stdin.read().split()))


start, end = 1, max(lan)
while start <= end:
    mid = (start + end) // 2
    lines = 0

    for i in lan:
        lines += i // mid

    # 나눠지는 랜선의 양이 목표값보다 더 많으면 탐색 시작점을 중간보다 한 칸 앞으로,
    # 목표값으로 딱 나눠지는 경우에는
        
    if lines >= N:
        start = mid + 1
    else:
        end = mid - 1
    
print(end)