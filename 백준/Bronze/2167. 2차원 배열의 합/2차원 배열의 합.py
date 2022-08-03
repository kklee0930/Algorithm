row, column = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(row)]

for _ in range(int(input())):
    result = 0
    i,j,x,y = map(int, input().split())
    for a in range(i-1, x):
        for b in range(j-1, y):
            result += matrix[a][b]
    print(result)