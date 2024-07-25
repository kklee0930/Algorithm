import sys

input = sys.stdin.readline

stair_cnt = int(input().strip())
stairs = [0 for _ in range(301)]
dp = [0 for _ in range(301)] # 계단 별 최대 점수 값

for i in range(stair_cnt):
    stairs[i] = int(input().strip())

dp[0] = stairs[0]
dp[1] = stairs[0] + stairs[1]
dp[2] = max(stairs[1] + stairs[2], stairs[0] + stairs[2])

# n-1 계단 밟기 vs n-2 계단 밟기
for i in range(3, stair_cnt):
    dp[i] = max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i])
    
print(dp[stair_cnt-1])