matrix = input().split()

min_lst = []
# 리스트 원소중에 '6' 있으면 '5'로 변환하여 min_lst에 담아주기
for i in matrix: # ['11', '25']
    if '6' in i:
        min_lst.append(i.replace('6', '5'))
    else:
        min_lst.append(i)
    
min_ = sum(map(int, min_lst))

max_lst = []
# 리스트 원소중에 '5' 있으면 '6'으로 변환하여 max_lst에 담아주기
for j in matrix:
    if '5' in j:
        max_lst.append(j.replace('5', '6'))
    else:
        max_lst.append(j)

max_ = sum(map(int, max_lst))

print(min_, max_)