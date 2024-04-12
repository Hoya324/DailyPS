from sys import stdin

def four_squares(n):
    # 주어진 값 n이 제곱수이면 1
    # n - i^2를 빼고 남은 수가 제곱수면 2
    # n - i^2 - j^2를 뺴고 남은 수가 제곱수면 3 
    # 나머지는 4
    if int(n**0.5) == n**0.5:
        return 1
    for i in range(1, int(n**0.5) + 1):
        if int((n - i**2)**0.5) == (n - i**2)**0.5:
            return 2
    for i in range(1, int(n**0.5) + 1):
        for j in range(1, int((n - i**2)**0.5) + 1):
            if int((n - i**2 - j**2)**0.5) == (n - i**2 - j**2)**0.5:
                return 3
    return 4


n = int(stdin.readline())
print(four_squares(n))