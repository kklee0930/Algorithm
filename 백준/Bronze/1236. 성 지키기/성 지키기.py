row, column = map(int,input().split())

matrix = [input() for _ in range(row)] 

row_cnt, column_cnt = 0, 0

# X가 들어있지 않은 행의 갯수
for i in range(row):
    if 'X' not in matrix[i]:
        row_cnt += 1

# X가 들어있지 않은 열의 갯수
for j in range(column):
    if 'X' not in [matrix[i][j] for i in range(row)]:
        column_cnt += 1

print(max(row_cnt, column_cnt))