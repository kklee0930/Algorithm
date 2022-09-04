from collections import deque

def bfs(x, y, color):
    count = 0
    queue = deque([])
    queue.append((x, y))
    visited[x][y] = 1

    while queue:
        x, y = queue.popleft()
        
        # 델타 탐색 좌표
        dx = [0,0,1,-1]
        dy = [1,-1,0,0]
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= row or ny < 0 or ny >= col:
                continue

            if graph[nx][ny] != color:
                continue

            if graph[nx][ny] == color and not visited[nx][ny]:
                visited[nx][ny] = 1
                queue.append((nx,ny))
                count += 1

    # 처음에 deque 생성하고 append 할 때 count안해서 +1
    return count + 1

# 그래프 정의
col, row = map(int, input().split())
graph = []
for _ in range(row):
    graph.append(list(map(str, input())))
    
# visited 정의
visited = [[0] * col for _ in range(row)] 

W_power, B_power = 0, 0

for i in range(row):
    for j in range(col):
        if graph[i][j] == 'W' and not visited[i][j]:
            W_power += bfs(i,j,'W') ** 2
        elif graph[i][j] == 'B' and not visited[i][j]:
            B_power += bfs(i,j,'B') ** 2
            
print(W_power, B_power)