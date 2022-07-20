import sys

a,b = map(int, input().split())
num_list = list(map(int, sys.stdin.readline().split()))

for i in num_list:
    if i < b:
        print(i, end=' ')