from collections import deque

row, col = map(int, input().split())
graph = []

for i in range(row):
    graph.append(list(map(int, input())))
# print(graph)
        
def bfs(x,y):
    # 델타탐색 좌표 정의
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    queue = deque([])
    queue.append((x, y))
    
    while queue:
        x, y = queue.popleft()
        
        # 델타 좌표 이동
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        
            # 좌표 벗어나지 않게 범위 제한
            if nx < 0 or nx >= row or ny < 0 or ny >= col:
                continue
            
            if graph[nx][ny] == 0:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))
    
    return graph[row-1][col-1]
                    
print(bfs(0,0))