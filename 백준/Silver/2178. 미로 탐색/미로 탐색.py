import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(n)]

def bfs(x, y):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    queue = deque([])
    queue.append((x,y))
    
    while queue:
        x, y = queue.popleft()
        
        # 델타 탐색
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
        
            # 범위 체크
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
        
            # 벽인지 체크
            if graph[nx][ny] == 0:
                continue
        
            # 이동 횟수 갱신
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    
    return graph[n-1][m-1]
    
print(bfs(0, 0))