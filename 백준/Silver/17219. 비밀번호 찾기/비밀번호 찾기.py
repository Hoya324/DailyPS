from sys import stdin

n, f = map(int, stdin.readline().split())

password = {}

for i in range(n):
    a, b = stdin.readline().split()
    password[a] = b

result = []

for i in range(f):
    key = stdin.readline().rstrip()
    result.append(password[key])

print('\n'.join(result))