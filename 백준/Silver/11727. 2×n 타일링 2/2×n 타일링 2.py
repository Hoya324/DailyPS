n = int(input())

dp = [0] * (n+1)


if n > 2:
    dp[1] = 1
    dp[2] = 3
    m = -1
    for i in range(3, n+1):
        dp[i] = dp[i-1] * 2 + m
        m *= -1

elif n == 1:
    dp[1] = 1
elif n == 2:
    dp[2] = 3

        
print(dp[n]%10007)