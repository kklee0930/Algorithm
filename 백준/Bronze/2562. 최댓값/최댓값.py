num_list = []
for i in range(9):
    a = int(input())
    num_list.append(a)

max_num = max(num_list)
print(max_num)
print(num_list.index(max_num) + 1)