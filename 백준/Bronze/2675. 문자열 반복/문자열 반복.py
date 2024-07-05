import sys

T = int(sys.stdin.readline())

for i in range(T):
    r, s = input().split()
    for j in s:
        print(int(r) * j, end="")
    print()