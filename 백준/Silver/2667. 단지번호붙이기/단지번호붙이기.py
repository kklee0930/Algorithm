import sys
sys.setrecursionlimit(100000)

# 행렬 생성
N = int(input())
matrix = [[] for _ in range(N)]
for i in range(N):
    danji = input()
    for j in danji:
        matrix[i].append(int(j))

def dfs(x, y):
    global count
    # 델타탐색 좌표
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    matrix[x][y] = 0
    for i in range(4):
        if -1 < x + dx[i] < N and -1 < y + dy[i] < N:
            nx = x + dx[i]
            ny = y + dy[i]
            
            if matrix[nx][ny] == 1:
                count += 1
                dfs(nx,ny)
answer = []
for i in range(N):
    for j in range(N):
        count = 0
        if matrix[i][j] == 1:
            count += 1
            dfs(i, j)
            answer.append(count)
        
print(len(answer))
answer.sort()
for i in answer:
    print(i)