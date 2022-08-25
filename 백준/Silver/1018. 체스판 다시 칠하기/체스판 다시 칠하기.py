y, x = map(int,input().split())

matrix = [[] for _ in range(y)]

# 행렬 생성
for i in range(y):
    str_ = input()
    for j in str_:
        matrix[i].append(j)

# 최대가 50X50체스판이기 때문에
min_val = 1250
# index out of range방지 하기 위해서 범위 조정
for i in range(y-7):
    for j in range(x-7):
        count1, count2 = 0, 0
        # 시작점에서 8칸이동한 범위
        for m in range(i, i + 8):
            for n in range(j, j + 8):
                if (m + n) % 2 == 0:
                    if matrix[m][n] != 'W':
                        count1 += 1
                    if matrix[m][n] != 'B':
                        count2 += 1
                else:
                    if matrix[m][n] != 'B':
                        count1 += 1
                    if matrix[m][n] != 'W':
                        count2 += 1
        min_ = min(count1,count2)
        if min_ < min_val:
            min_val = min_
print(min_val)