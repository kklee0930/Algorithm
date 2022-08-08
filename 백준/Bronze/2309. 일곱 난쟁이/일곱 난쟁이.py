total = 0
lst = []
for _ in range(9):
    height = int(input())
    lst.append(height)
    
# 총 sum은 140인데 일곱명이 100이 되어야 하므로 두명이 40될경우 제거
total = sum(lst)
for i in range(9):
    for j in range(i+1, 9):
        if lst[i] + lst[j] == total - 100:
            num1, num2 = lst[i], lst[j] 
            lst.remove(num1)
            lst.remove(num2)
            lst.sort()
            
            for i in lst:
                print(i)
            break
    if len(lst) < 9:
        break