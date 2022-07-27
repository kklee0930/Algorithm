del_str = 'CAMBRIDGE'
lst = []

lst.extend(input())

for i in del_str:
    for j in range(len(lst)):
        if i == lst[j]:
            lst[j] = ''
print(''.join(lst))
