from sys import stdin 

count = int(input())

arr = [[False for j in range(100)] for i in range(100)]

for i in range(count):
    x, y = map(int, stdin.readline().split())

    for n in range(y-1, y+9):
        for m in range(x-1, x+9):
            if arr[n][m] == False:
                arr[n][m] = True
    

result = 0

for i in range(100):
    result += arr[i].count(True)



print(result)