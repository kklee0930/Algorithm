import sys
sys.setrecursionlimit(100000)

N = int(sys.stdin.readline())

graph = []
max_ = 0

def dfs(x : int, y : int, height : int):

    # 상하좌우 델타탐색
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        # 그래프 범위 내이고 물에 잠기지 않으며 미방문일경우 재귀
        if -1 < nx < N and -1 < ny < N:
            if graph[nx][ny] > height and not visited[nx][ny]:
                visited[nx][ny] = 1
                dfs(nx, ny, height)


for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split())))

    # 최대높이정보 갱신
    for height in graph[i]:
        if height > max_:
            max_ = height

safe_zone = []

# 1부터 최대높이까지 탐색
for height in range(1, max_):
    
    # 매번 초기화
    cnt = 0
    visited = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            
            # 미방문이고 높이가 현재 탐색 높이보다 높을 경우 재귀 / 물에 잠기지 않은 지역++ / 방문처리
            if graph[i][j] > height and not visited[i][j]:
                dfs(i, j, height)
                visited[i][j] = 1
                cnt += 1

    safe_zone.append(cnt)
    
# 물에 잠긴 지역이 없으면 1개의 지역
if sum(safe_zone) == 0:
    print(1)
else:
    print(max(safe_zone))