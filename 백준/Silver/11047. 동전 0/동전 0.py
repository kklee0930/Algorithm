import sys

input = sys.stdin.readline

N, K = map(int, input().strip().split()) # 동전의 종류, 가치의 합

coins = []

for _ in range(N):
    coins.append(int(input().strip()))
    
coins.sort(reverse=True)
cnt = 0

for coin in coins:
    cnt += K // coin
    K %= coin
    if not K:
        break

print(cnt)