from sys import stdin

n = int(input())
schedule = []
for i in range(n):
    a = tuple(map(int, stdin.readline().split()))
    schedule.append(a)

schedule = sorted(schedule, key=lambda x: (x[1], x[0]))

last = schedule[0][1]
count = 1
for i in range(1, n):
    if last <= schedule[i][0]:
        last = schedule[i][1]
        count += 1

print(count)