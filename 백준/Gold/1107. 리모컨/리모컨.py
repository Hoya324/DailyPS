from sys import stdin

chan = int(input())
n = int(input())
broken = list(map(int, stdin.readline().split()))

arr = [0,1,2,3,4,5,6,7,8,9]

for i in broken:
    if i in arr:
        arr.remove(i)

string = str(chan)
count = 0

p = 0
m = 0
ans = []

    

while True:
    if n == 10:
        break
        
    data = chan + p
    if data > 5000000:
        break
        
    plus = list(str(data)) 
    tmp = []
    
    for i in plus:
        if int(i) in arr:
            tmp.append(i)
            
        else:
            tmp = []
            
            break

    if tmp == []:
        p += 1
    else:
        ans.append(abs(int(''.join(tmp)) - chan) + len(tmp))
        break

while True:
    if n == 10:
        break
    data = chan - m
    if data < 0:
        break
    minus = list(str(data))
    tmp = []
    
    for i in minus:
        if int(i) in arr:
            tmp.append(i)
            
        else:
            tmp = []
            
            break
            
    if tmp == []:
        m += 1
    else:
        ans.append(abs(int(''.join(tmp)) - chan) + len(tmp))
        break

if n == 10:
    count = abs(chan - 100)
else:
    count += min(ans)

if abs(chan - 100) < count:
    print(abs(chan - 100))
else:
    print(count)