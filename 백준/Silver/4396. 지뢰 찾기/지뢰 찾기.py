# 델타탐색 이동좌표
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [1, 0, -1, 1, -1, 1, 0, -1]

num = int(input()) # N x N 그래프

# 지뢰 그래프와 탐색 그래프
board = [list(input()) for _ in range(num)] 
matrix = [list(input()) for _ in range(num)]
result = [['.'] * num for _ in range(num)]

for i in range(num):
    for j in range(num):
        
        if board[i][j] == '.' and matrix[i][j] == 'x':
            count = 0
            
            for k in range(8):
                nx = i + dx[k]
                ny = j + dy[k]
                
                if  nx < 0 or nx >= num or ny < 0 or ny >= num:
                    continue
                
                if board[nx][ny] == '*':
                    count += 1
                
            result[i][j] = count

        if board[i][j] == '*' and matrix[i][j] == 'x':        
            for r in range(num):
                for c in range(num):
                    if board[r][c] == '*':
                        result[r][c] = '*'
                        
for i in range(num):
    for j in range(num):
        print(result[i][j], end='')
    print()