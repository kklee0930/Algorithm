import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline
N, M = map(int, input().strip().split()) # 세로 N, 가로 M
graph = [list(input().strip()) for _ in range(N)]
visited = [[0] * (M) for _ in range(N)] # 방문처리
cnt = 0 # 나무판자 갯수

def dfs(symbol: str, row: int, col: int):

    # 가로 방향의 나무판자면 가로로 이동하면서 같은지 체크 후 같으면 방문 처리 및 재귀
    if symbol == "-":
        right = col + 1
        
        if 0 <= right < M:
            
            if graph[row][right] == symbol:
                visited[row][right] = 1
                dfs(graph[row][right], row, right)
                
    # 세로 방향의 나무판자면 세로로 이동하면서 같은지 체크 후 같으면 방문 처리 및 재귀
    else:
        down = row + 1

        if 0 <= down < N:
            
            if graph[down][col] == symbol:
                visited[down][col] = 1
                dfs(graph[down][col], down, col)
    return
                
for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            visited[i][j] = 1
            cnt += 1
            dfs(graph[i][j], i, j)
print(cnt)