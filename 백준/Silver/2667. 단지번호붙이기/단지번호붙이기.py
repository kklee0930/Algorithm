import sys
from collections import deque

input = sys.stdin.readline

N = int(input().strip()) # 지도 크기
graph = [list(map(int, input().strip())) for _ in range(N)] # 그래프
visited = [[0] * N for _ in range(N)] # 방문여부

def bfs(r: int, c: int, cnt: int):
    
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    
    queue = deque([])
    queue.append((r, c))
    
    while queue:
        row, col = queue.popleft()
        
        # 좌우상하 탐색
        for i in range(4):
            nx = dx[i] + row
            ny = dy[i] + col

            # 범위 체크
            if 0 <= nx < N and 0 <= ny < N:
                # 0이거나 방문했으면 continue
                if not graph[nx][ny] or visited[nx][ny]: continue
                # 아니면 큐에 추가 & cnt++
                visited[nx][ny] = 1
                cnt += 1
                queue.append((nx, ny))
    return cnt

answer = []
for i in range(N):
    for j in range(N):
        # 방문하지 않았고 좌표 값이 1이면
        if not visited[i][j] and graph[i][j]:
            visited[i][j] = 1
            answer.append(bfs(i, j, 1))
            
print(len(answer))
for n in sorted(answer):
    print(n)