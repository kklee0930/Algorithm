import sys
from collections import deque
input = sys.stdin.readline

# 1초에 이동 가능한 최대 이동거리 K
row, col, K = map(int, input().split())
graph = [list(map(str,input().strip())) for _ in range(row)]
visited = [[0]*col for _ in range(row)]

# depart: x1, y1 / destination: x2, y2
x1, y1, x2, y2 = map(int, input().split())

# 인덱스 접근 위해 -1
queue = deque()
queue.append((x1-1,y1-1))

while queue:
    x, y = queue.popleft()
    
    if x == x2-1 and y == y2-1:
        print(visited[x][y])
        exit()
        
    # 델타탐색
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    for i in range(4):
        for multiplier in range(1, K+1):
            nx = x + (multiplier*dx[i])
            ny = y + (multiplier*dy[i])
            
            if nx < 0 or nx >= row or ny < 0 or ny >= col:
                break
            if graph[nx][ny] == '#':
                break
            if visited[nx][ny] == 0:
                queue.append((nx,ny))
                visited[nx][ny] = visited[x][y] + 1
            elif visited[nx][ny] == visited[x][y] + 1:
                continue
            else:
                break
print(-1)