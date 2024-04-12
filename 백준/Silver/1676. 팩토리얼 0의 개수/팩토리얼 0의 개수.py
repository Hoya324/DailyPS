def factorial(N):
    ans = 1
    for i in range(1, N+1):
        ans *= i
    return ans

N = int(input())
string = str(factorial(N))
count = 0
for i in range(len(string) - 1, 0, -1):
    if string[i] == '0':
        count += 1
    else:
        break

print(count)