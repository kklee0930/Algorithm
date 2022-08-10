lst = []
for _ in range(3):
    lst.append(int(input()))

dict = {}
for i in lst:
    if i not in dict:
        dict[i] = 1
    else:
        dict[i] += 1
        
if sum(lst) == 180:
    if lst.count(60) == len(lst):
        print('Equilateral')
    elif 2 in dict.values():
        print('Isosceles')
    else:
        print('Scalene')
else:
    print('Error')