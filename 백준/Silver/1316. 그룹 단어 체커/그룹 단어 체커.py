def solve(N):
    for i in range(N):
        text = input()
        for i in range(len(text)-1):
            if  text.find(text[i]) > text.find(text[i+1]):
                N -= 1
                break
    return N

N = int(input())
print(solve(N))
