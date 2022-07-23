import sys

my_list = []

T = int(input())
for tc in range(1, T+1):
    n = int(sys.stdin.readline())
    my_list.append(n)
my_list.sort()

for i in my_list:
    print(i)