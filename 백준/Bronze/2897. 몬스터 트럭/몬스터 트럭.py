row, col = map(int,input().split())
parking_lot = [input() for _ in range(row)]

# 부순 차의 갯수 변수
zero_crush = 0 
one_crush = 0
two_crush = 0
three_crush = 0
four_crush = 0

for i in range(row):
    for j in range(col):
        # 제한 범위 설정
        if i + 1 == row or j + 1 == col:
            break 
        o = parking_lot[i][j] # 원점
        x = parking_lot[i][j+1] # x축 1칸 이동
        y = parking_lot[i+1][j] # y축 1칸 이동
        z = parking_lot[i+1][j+1] # x,y축 1칸 이동(대각선)

        result = o+x+y+z
        
        if '#' in result:
            continue
        else:
            crush = result.count('X')
            if crush == 0:
                zero_crush += 1
            elif crush == 1:
                one_crush += 1
            elif crush == 2:
                two_crush += 1
            elif crush == 3:
                three_crush += 1
            elif crush == 4:
                four_crush += 1
                
print(zero_crush)
print(one_crush)
print(two_crush)
print(three_crush)
print(four_crush)