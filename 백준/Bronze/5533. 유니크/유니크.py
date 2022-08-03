from pprint import pprint

n = int(input())
matrix = [[],[],[]]

for _ in range(n):
    a,b,c = map(int, input().split())
    matrix[0].append(a)
    matrix[1].append(b)
    matrix[2].append(c)

score = [0] * n

for i in range(3): # 0,1,2
    for j in range(n): # 0,1,2,3,4
        if matrix[i].count(matrix[i][j]) <= 1:
            score[j] += matrix[i][j]

for i in score:
    print(i)
            