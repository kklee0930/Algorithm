import sys
input = sys.stdin.readline

n = int(input())
num_lst = [0] * 10001

for i in range(n):
    num = int(input())
    num_lst[num] += 1

for j in range(len(num_lst)):
    if num_lst[j] != 0:
        for k in range(num_lst[j]):
            print(j)