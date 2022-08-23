from collections import deque

# 행렬 생성해주기
M,N = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(N)]

queue = deque([])

# 델타탐색 좌표
dx = [0,0,1,-1]
dy = [1,-1,0,0]

answer = 0

# 일단 전체 행렬 순회하면서 익은 토마토의 위치 좌표를 기록해주기(중요)
for i in range(N):
    for j in range(M):
        if matrix[i][j] == 1:
            queue.append([i,j]) # 중요
            
def bfs():
    while queue:
        # 토마토좌표
        x, y = queue.popleft() #중요

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if -1 < nx < N and -1 < ny < M and matrix[nx][ny] == 0:
                # 익는데 걸리는 시간을 계산하기 위해서 + 1
                matrix[nx][ny] = matrix[x][y] + 1
                queue.append([nx,ny])
bfs()
for i in matrix:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    answer = max(answer, max(i))

# 1부터 시작했기 때문에 -1해준다.
print(answer-1)