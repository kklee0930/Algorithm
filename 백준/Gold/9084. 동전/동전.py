import sys

input = sys.stdin.readline

for _ in range(int(input().strip())):
    N = int(input().strip()) # 주어진 동전의 개수
    coins = list(map(int, input().strip().split())) # 주어진 동전의 종류
    M = int(input().strip()) # 만들어야 하는 금액
    
    dp = [0] * (M+1)
    dp[0] = 1
    
    for coin in coins: # 동전의 종류
        for money in range(M+1): # 0원부터 M원까지
            if coin <= money: # 동전의 값이 현재 만드려고 하는 액수보다 작을 때에만
                dp[money] += dp[money-coin]
    print(dp[M])