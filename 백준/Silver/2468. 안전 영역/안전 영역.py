import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

# 행렬크기, 행렬 입력받기
size = int(input())
matrix = []
max_ = 0
for i in range(size):
    matrix.append(list(map(int,input().split())))
    for j in range(size):
        if matrix[i][j] > max_:
            max_ = matrix[i][j]

def dfs(x, y, height):
    # 델타 이동 좌표
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    for delta in range(4):
        nx = x + dx[delta]
        ny = y + dy[delta]
        
        if (-1 < nx < size) and (-1 < ny < size):
            if matrix[nx][ny] > height and not visited[nx][ny]:
                visited[nx][ny] = 1
                dfs(nx, ny, height)

answer = []
# 높이는 1이상 max_미만의 정수(max_포함시 안전구역 없어짐)
for height in range(1, max_):
    # 카운트와 visited 행렬을 매번 초기화
    count = 0
    visited = [[0]*size for _ in range(size)]
    
    for i in range(size):
        for j in range(size):
            if matrix[i][j] > height and not visited[i][j]:
                dfs(i, j, height)
                visited[i][j] = 1
                count += 1
    answer.append(count)
    
# 잠기는 영역 없을경우 안전지대 1개
if sum(answer) == 0:
    print(1)
else:
    print(max(answer))