def solution(n):
    dp = [0 for _ in range(60001)]
    dp[1], dp[2] = 1, 2
    if n == 1 or n == 2:
        return dp[n]
    else:
        for i in range(3, 60001):
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007
            if i == n:
                return dp[i]