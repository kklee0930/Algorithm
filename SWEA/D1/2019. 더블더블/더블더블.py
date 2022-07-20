N = int(input())
num_list = []
a = 1
count = 0
while count <= 8:
    num_list.append(a)
    a *= 2
    count += 1
for i in num_list:
    print(i, end=' ')