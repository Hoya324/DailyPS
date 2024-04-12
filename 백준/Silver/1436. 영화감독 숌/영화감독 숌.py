N = int(input())

count = 0
title = 666

while True:
    if "666" in str(title):
        count += 1
    if count == N:
        print(title)
        break
    title += 1