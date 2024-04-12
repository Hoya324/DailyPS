from sys import stdin

N = int(input())
user_card = set(map(int, stdin.readline().split()))
M = int(input())
check_card = list(map(int, stdin.readline().split()))

def solution():
  result = ""
  for i in check_card:
    if i in user_card:
      result += "1 "
    else:
      result += "0 "
  
  return result

print(solution())