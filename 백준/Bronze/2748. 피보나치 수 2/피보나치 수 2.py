import sys

input = sys.stdin.readline

n = int(input().strip())
dp = [0] * (n+1)

def fibonacci(n, dp):
    if dp[n]:
        return dp[n]
    if n <= 1:
        return n
    dp[n] = fibonacci(n-2, dp) + fibonacci(n-1, dp)
    return dp[n]

print(fibonacci(n, dp))