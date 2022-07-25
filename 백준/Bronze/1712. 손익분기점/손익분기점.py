from sys import stdin
A,B,C = map(int, stdin.readline().split())
n = 1

if B < C:
    difference = C - B
    n = (A // difference) + 1
    print(n)

else:
    print(-1)