from sys import stdin

T = int(input())
for _ in range(T):
    n = int(input())
    fassion = {}
    for i in range(n):
        a, b = stdin.readline().split()
        if b in fassion.keys():    
            fassion[b].append(a)
        else:
            fassion[b] = [a]

    result = 1

    for i in fassion.values():
        result *= (len(i) + 1)

    print(result - 1)