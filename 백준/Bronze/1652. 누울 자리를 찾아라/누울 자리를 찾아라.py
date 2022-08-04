n = int(input())
matrix = [input() for _ in range(n)]

result = [0,0]

for i in range(n):
    row_cnt, column_cnt = 0, 0
    for j in range(n):
        # 행방향
        if matrix[i][j] == '.':
            row_cnt += 1
        else:
            row_cnt = 0 
        if row_cnt == 2:
            result[0] += 1
        
        # 열방향
        if matrix[j][i] == '.':
            column_cnt += 1
        else:
            column_cnt = 0
        if column_cnt == 2:
            result[1] += 1

print(*result)