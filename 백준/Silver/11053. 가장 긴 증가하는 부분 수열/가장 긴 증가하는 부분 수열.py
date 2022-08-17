n = int(input())

num = list(map(int, input().split()))
    
dp = [0] * n

for i in range(n): # 0,1,2,3,4,5
    for j in range(i): # 0,1,2,3,4
        if num[i] > num[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(max(dp))