for _ in range(int(input())):
    row, col = map(int,input().split())
    count = 0
    matrix = [list(map(int,input().split())) for _ in range(row)]
    
    for i in range(col):
        for j in range(row-1, -1, -1):
            if matrix[j][i] == 1:
                while True:
                    if j + 1 == row:
                        break
                    elif matrix[j+1][i] == 1:
                        break
                    matrix[j][i] = 0
                    matrix[j+1][i] = 1
                    j += 1
                    count += 1
    print(count)