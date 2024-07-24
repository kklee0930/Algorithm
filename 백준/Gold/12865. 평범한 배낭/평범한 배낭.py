import sys

input = sys.stdin.readline
N, K = map(int, input().strip().split()) # 물품의 수, 버틸 수 있는 무게

weights = []
values = []

for _ in range(N):
    W, V = map(int, input().strip().split())
    weights.append(W)
    values.append(V)

def knapsack(weights, values, dp):
    for i in range(1, N+1): # 물품 갯수 iteration
        for w in range(1, K+1): # 남은 배낭 무게 iteration
            if weights[i-1] <= w: # 넣으려고 하는 물품 무게가 남은 배낭 용량보다 작으면 추가
                dp[i][w] = max(dp[i-1][w], dp[i-1][w - weights[i-1]] + values[i-1])
            else:
                dp[i][w] = dp[i-1][w]
            
    return dp[N][K]

dp = [[0 for _ in range(K+1)] for _ in range(N+1)]
print(knapsack(weights, values, dp))