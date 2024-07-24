import sys

input = sys.stdin.readline

N = int(input().strip())
A = list(map(int, input().strip().split()))
dp = [0] * N

for i in range(N):
    for j in range(i):
        # 현재 값이 이전 값보다 크고 현재 누적 길이가 이전 누적 길이보다 더 작을 경우 갱신
        if A[i] > A[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1 # i 인덱스를 수열의 첫 번째로 지정하는 경우를 가정
print(max(dp))