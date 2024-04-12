def fibo(n):    
    dp[0] = [1, 0]
    dp[1] = [0, 1]

    if n == 0:
        return dp[0]
    if n == 1:
        return dp[1]

    if dp[n] != 0:
        return dp[n]

    dp[n] = [fibo(n-1)[0] + fibo(n-2)[0], fibo(n-1)[1] + fibo(n-2)[1]]
    return dp[n]
     



T = int(input())

for _ in range(T):
    n = int(input())
    dp = [0] * 41
    fibo(n)
    print(dp[n][0], dp[n][1])