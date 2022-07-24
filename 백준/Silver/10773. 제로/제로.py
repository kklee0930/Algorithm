from sys import stdin

stack = []
K = int(stdin.readline())
for i in range(1, K+1):
    n = int(stdin.readline())
    if n == 0:
        stack.pop()
    else:
        stack.append(n)
print(sum(stack))