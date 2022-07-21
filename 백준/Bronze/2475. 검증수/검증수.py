n = list(map(int, input().split()))

my_list = []

for i in n:
    i **= 2
    my_list.append(i)
print(sum(my_list) % 10)