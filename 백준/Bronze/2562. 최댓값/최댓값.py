import sys

dict = {}

for i in range(1, 10):
    num = int(sys.stdin.readline())
    dict[num] = i

max_val = max(dict.keys())

print(max_val)
print(dict[max_val])