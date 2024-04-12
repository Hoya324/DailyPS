import sys
input = sys.stdin.readline
N = int(input())
graph = []
for i in range(N):
   graph.append(list(map(int, input().rstrip())))

 # 다른 방법으로는 nonlocal count_house
    #nonlocal 이 사용된 함수 바로 한단계 바깥쪽에 위치한 변수와 바인딩을 할 수 있다.
def dfs_complex(graph, x, y):
  if x <= -1 or x >= N or y <= -1 or y >= N:
    return 0
  if graph[x][y] == 1:
    count_house = 1
    graph[x][y] = 0
    count_house += dfs_complex(graph, x - 1, y)
    count_house += dfs_complex(graph, x, y - 1)
    count_house += dfs_complex(graph, x + 1, y)
    count_house += dfs_complex(graph, x, y + 1)
    return count_house
  return 0

results = []
for i in range(N):
  for j in range(N):
    result = dfs_complex(graph, i ,j)
    if result > 0:
      results.append(result)

print(len(results))
results.sort()
for i in results:
  print(i)
