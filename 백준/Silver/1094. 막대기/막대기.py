x = int(input())
stick, result, count = 64, 0, 0

while True:
    if stick == x:
        count += 1
        break
    
    if stick < x:
        result += stick
        count += 1

        if result == x:   
            break

        if result > x:
            result -= stick
            count -= 1

    stick //= 2

print(count)