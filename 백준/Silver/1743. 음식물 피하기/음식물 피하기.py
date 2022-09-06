import sys
sys.setrecursionlimit(100000)

row, col, trash = map(int, input().split())

# 인덱스 접근 편리하게 하기 위해서
graph = [[0]*(col+1) for _ in range(row+1)]
visited = [[0]*(col+1) for _ in range(row+1)]

for _ in range(trash):
    x, y = map(int, input().split())
    graph[x][y] = 1

def dfs(x, y):
    global count
    visited[x][y] = 1
    
    # 델타 좌표 변환
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx <= row and 0 <= ny <= col and graph[nx][ny] == 1:
            if not visited[nx][ny]:
                count += 1
                visited[nx][ny] = 1
                dfs(nx,ny)
            
    return count

result = []

for i in range(1, row+1):
    for j in range(1, col+1):
        if graph[i][j]:
            count = 1
            result.append(dfs(i,j))
                 
print(max(result))