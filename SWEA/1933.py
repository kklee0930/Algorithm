N = int(input())
num_list = []
for i in range(1, N+1):
    if N % i == 0:
        num_list.append(i)
num_list.sort()
for i in num_list:
    print(i, end=' ')