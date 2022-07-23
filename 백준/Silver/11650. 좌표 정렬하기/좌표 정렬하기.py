T = int(input())
my_list = []
for tc in range(1, T+1):
    pair = list(map(int, input().split()))
    my_list.append(pair)
sorted_list = sorted(my_list)
for element in sorted_list:
    print(element[0], element[1])