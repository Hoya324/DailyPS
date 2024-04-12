from sys import stdin
from collections import deque

def solution(List, command):
    a = 1
    for i in command:
        if i == "R":
            a *= -1
        if i == "D":
            if len(List) == 0:
                return "error"
            if a == -1:
                List.pop()
            elif a == 1:
                List.popleft()

    if a == -1:
        List.reverse()
        
    return list(List)
     

T = int(input())
for _ in range(T):
    command = stdin.readline().rstrip()
    n = int(stdin.readline())
    list_data = stdin.readline().strip("[""]""\n")
    
    if n == 0:
        List = deque()
    elif n == 1:
        List = deque([int(list_data)])
    else:
        if "," in list_data:
            List = deque(map(int, list_data.split(",")))
            
    result = solution(List, command)
    if result == 'error':
        print("error")
    else:
        a = '[' + ','.join(str(x) for x in result) + "]" 
        print(a)
