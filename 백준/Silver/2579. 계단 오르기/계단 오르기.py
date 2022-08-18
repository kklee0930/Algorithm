num = int(input())
stairs = [0 for _ in range(301)]
dp = [0 for _ in range(301)]

for i in range(num):
    stairs[i] = int(input())

dp[0] = stairs[0]
dp[1] = stairs[0] + stairs[1]
dp[2] = max(stairs[1]+stairs[2], stairs[0]+stairs[2])

# 마지막 계단의 전 계단을 밟는 경우와 밟지 않는 경우
for i in range(3, num):
    dp[i] = max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i])
print(dp[num-1])