N = int(input())
my_list = []
for i in range(1, N+1):
    n = int(input())
    my_list.append(n)
my_list = sorted(my_list)
for j in my_list:
    print(j)