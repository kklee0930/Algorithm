my_lst = []
for i in range(28):
    my_lst.append(int(input()))
result = []
for i in range(1, 31):
    if i not in my_lst:
        result.append(i)
result.sort()
print(result[0])
print(result[1])