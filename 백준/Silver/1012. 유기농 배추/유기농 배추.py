import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

Test = int(input())

def earthworm(x, y, graph, width, length, location):   
  if x <= -1 or y <= -1 or x >= width or y >= length:
    return 0
  if graph[y][x] == 1:
    graph[y][x] = 0
    earthworm(x + 1, y, graph, width, length, location)
    earthworm(x - 1 , y, graph, width, length, location)
    earthworm(x, y + 1, graph, width, length, location)
    earthworm(x, y - 1, graph, width, length, location)
    return 1
  return 0

for _ in range(Test):
  
  width, length, location = list(map(int, input().split()))
  graph = [[0] * width for _ in range(length)]

  for _ in range(location):
    x, y = list(map(int, input().split()))
    graph[y][x] = 1

  count = 0
  for j in range(length):
    for i in range(width):
      if earthworm(i, j, graph, width, length, location) > 0:
        count += 1
  
  print(count)