import sys
from collections import deque
input = sys.stdin.readline

graph = [] # 3차원 토마토 상자
queue = deque([]) # bfs

col, row, height = map(int, input().split())

for h in range(height):
    temp = []
    for r in range(row):
        temp.append(list(map(int, input().split())))
        for c in range(col):
            if temp[r][c] == 1: # 익은 토마토면 queue에 저장
                queue.append((r, c, h))

    graph.append(temp)
    
def bfs():
    dx = [0, 0, 1, -1, 0, 0]
    dy = [1, -1, 0, 0, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]
    
    while queue:
        r, c, h = queue.popleft()
        
        # 상하좌우앞뒤 이동
        for i in range(6):
            nx = dx[i] + r
            ny = dy[i] + c
            nz = dz[i] + h
            
            # 범위 체크
            if nx < 0 or ny < 0 or nz < 0 or nx >= row or ny >= col or nz >= height:
                continue
            
            # 안익은 토마토인지 체크
            if graph[nz][nx][ny] != 0:
                continue
            
            queue.append((nx, ny, nz))
            graph[nz][nx][ny] = graph[h][r][c] + 1
            
bfs()
cnt = -1
for i in graph: # 높이
    for j in i: # 가로방향
        for k in j: # 세로방향
            if k == 0: # 안익은 토마토가 있으면 -1
                print(-1)
                exit(0)
        cnt = max(cnt, max(j))

# 시작이 1이므로 cnt--
print(cnt-1)