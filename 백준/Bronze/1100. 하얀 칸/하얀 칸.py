count = 1 # n번째 행
F_count = 0 # 말의 갯수
while count < 9:
    row_count = 1 # 행에서의 index
    lst = []
    lst.extend(input())
    if count % 2 != 0:
        for i in lst:
            if row_count % 2 != 0 and i == 'F':
                F_count += 1
            row_count += 1
            
    elif count % 2 == 0:
        for i in lst:
            if row_count % 2 == 0 and i == 'F':
                F_count += 1
            row_count += 1
    count += 1
    
print(F_count)