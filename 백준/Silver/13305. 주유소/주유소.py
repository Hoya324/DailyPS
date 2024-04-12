import sys

N = int(input())
distance = list(map(int, sys.stdin.readline().split()))
price = list(map(int, sys.stdin.readline().split()))

#첫 이동을 위한 고정비용
#가장 싼 비용으로 많은 거리를 이동하는 것
result = price[0] * distance[0]

cost = price[0]
for i in range(1, N-1):
  
  if price[i] < cost: 
    cost = price[i]
    result += cost * distance[i] 
  else:
    result += cost * distance[i]


print(result)