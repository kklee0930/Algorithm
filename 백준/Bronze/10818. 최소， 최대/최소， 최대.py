N = int(input())
num_list = []
a = map(int, input().split())
num_list.extend(a)
print(min(num_list), max(num_list))