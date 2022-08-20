import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(row, column):
    # 델타탐색 좌표
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    for i in range(4):
        nx = row + dx[i]
        ny = column + dy[i]
        
        # 범위 제한/ -1로 변환
        if -1 < nx < n and -1 < ny < m:
            if matrix[nx][ny] == 1:
                matrix[nx][ny] = -1
                dfs(nx,ny)

T = int(input())
for _ in range(T):
    m,n,k = map(int, input().split())

    # 매트릭스 생성
    matrix = [[0]*m for _ in range(n)]
    for _ in range(k):
        y, x = map(int, input().split())
        matrix[x][y] = 1

    count = 0
    for row in range(n):
        for column in range(m):
            if matrix[row][column] == 1:
                dfs(row, column)
                count += 1
    print(count)