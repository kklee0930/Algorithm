# 100X100 크기의 좌표만듦
x, y = 100, 100

matrix = [[0] * y for _ in range(x)]
area = 0

for _ in range(1,5):
    x1,y1,x2,y2 = map(int,input().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            if matrix[i][j] != 1:
                matrix[i][j] = 1
                area += 1
print(area)