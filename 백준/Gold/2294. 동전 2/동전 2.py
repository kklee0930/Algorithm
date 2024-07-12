import sys
input = sys.stdin.readline

n, k = map(int, input().split()) # 동전 갯수, 가치의 합
coins = [] # 각 동전의 가치를 저장하는 배열
dp = [10001] * (k+1) # 동전 합에 소요되는 최소 동전 개수 저장하는 dp 배열
dp[0] = 0 # 동전 합 0의 사용 가능 동전 갯수는 0개

for i in range(n):
    coins.append(int(input()))

# 동전 갯수 인덱스
for i in range(0, n):
    coin = coins[i]
    # i번째 동전값부터 k값까지 loop
    for j in range(coin, k+1):
        """
        dp[j]: 합 j를 구성하기 위한 최소 동전 수
        min(dp[j], dp[j - coin] + 1): 현재 최소값과 기존 값에서 동전 1개 추가한 값 비교
        """
        dp[j] = min(dp[j], dp[j - coin] + 1)

value = -1 if dp[k] == 10001 else dp[k]
print(value)