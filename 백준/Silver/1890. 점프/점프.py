import sys

input = sys.stdin.readline

N = int(input().strip()) # 게임 판의 크기
graph = [[0] * (N) for _ in range(N)]
dp = [[0] * (N) for _ in range(N)] # 좌표 별 도달 가능 경로 수

for i in range(N):
    data = list(map(int, input().strip().split()))
    graph[i] = data

dp[0][0] = 1 # 시작지점 도달 방법은 1가지
for i in range(N):
    for j in range(N):
        current = graph[i][j] # 현재 좌표의 점프 가능 거리
        
        # 해당 좌표에서의 점프 가능 여부 확인
        if current == 0:
            continue
        
        # 범위를 벗어나지 않으면 점프 처리
        if i+current < N:
            dp[i+current][j] += dp[i][j]
            
        if j+current < N:
            dp[i][j+current] += dp[i][j]
            
print(dp[N-1][N-1])