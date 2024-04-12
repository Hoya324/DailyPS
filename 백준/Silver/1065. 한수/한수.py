def hansu(N):
    empty_list = []
    for i in range(1,N+1):
        K = map(int, list(str(i)))
        R = list(K)
        length = len(R)
        if R[-1] == R[0] + (length - 1)*(R[length-1]-R[length-2]):
            empty_list.append(i)
    return print(len(empty_list))

N = int(input())
hansu(N)