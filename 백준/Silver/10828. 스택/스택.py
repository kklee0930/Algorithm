import sys

stack = []

T = int(input())
for tc in range(1, T+1):
    cmd = list(sys.stdin.readline().split())

    if 'push' in cmd:
        stack.append(cmd[1])

    elif 'pop' in cmd:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())

    elif 'size' in cmd:
        print(len(stack))

    elif 'empty' in cmd:
        if len(stack) == 0:
            print(1)
        else:
            print(0)

    elif 'top' in cmd:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
