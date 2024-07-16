from collections import deque
import sys

input = sys.stdin.readline
row, col = map(int, input().strip().split())

graph = [list(map(int, input().strip().split())) for _ in range(row)]
time = 0 # 빙산이 나누어 질 때까지 햇수
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 전체 graph를 bfs를 통해 visited 처리를 해주기 위한 코드
def bfs(r, c, visited):
    queue = deque([])
    queue.append((r, c))
    
    while queue:
        r, c = queue.popleft()
        
        for k in range(4):
            nx = dx[k] + r
            ny = dy[k] + c

            if 0 <= nx < row and 0 <= ny < col:
                if not visited[nx][ny] and graph[nx][ny] != 0:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
    return visited

# bfs를 통해 빙산이 분리되었는지 확인하기 위한 작업
def seperated_check():
    chunk = 0 # 빙산 덩어리 갯수
    visited = [[0] * col for _ in range(row)]
    
    for i in range(row):
        for j in range(col):
            if graph[i][j] != 0 and not visited[i][j]:
                chunk += 1
                if chunk > 1:
                    return 1
                visited[i][j] = 1
                bfs(i, j, visited)
    return 0

# 빙산 녹여주기 위한 함수
def melt_ice():
    
    iceberg = 0 # 전체 graph에서 빙산 존재 여부
    
    for i in range(row):
        for j in range(col):
            
            # 현재 좌표가 바다이면 continue
            if graph[i][j] == 0:
                continue
            
            iceberg = 1
            
            sea_water = 0 # 바다로 둘러싸인 빙산의 면 개수(최대 4개)
            height = graph[i][j] # 현재 빙산의 높이
            
            for k in range(4):
                nx = dx[k] + i
                ny = dy[k] + j

                # 범위를 벗어나지 않고 바다이면 바다와 인접하는 면++
                if 0 <= nx < row and 0 <= ny < col:
                    if graph[nx][ny] == 0:
                        sea_water += 1
            
            graph[i][j] = -1 if height <= sea_water else height - sea_water  
            
    return iceberg

seperated = 0 # 빙산 최종 분리 여부 확인 값

while True:
    
    time += 1
    
    # 빙산이 나뉘지 않고 다 녹아서 없어졌으면 0 출력
    if melt_ice() == 0:
        print(0)
        sys.exit(0)

    # -1이 된 빙산들의 값을 0으로 바꿔주기 위한 작업
    for i in range(row):
        for j in range(col):
            if graph[i][j] == -1:
                graph[i][j] = 0
    
    # 빙산이 분리되었는지 확인
    if seperated_check() == 1:
        seperated = 1
        break

print(time)