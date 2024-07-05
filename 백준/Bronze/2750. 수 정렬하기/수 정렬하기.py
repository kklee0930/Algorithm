import sys

lst = []
for _ in range(int(input())):
    lst.append(int(sys.stdin.readline()))

lst.sort()
for n in lst:
    print(n)