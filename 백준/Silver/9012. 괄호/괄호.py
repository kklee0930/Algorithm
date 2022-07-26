from collections import deque

n = int(input())
for i in range(1, n+1):
    dq = deque()
    VPS = input()
    for j in VPS:
        if len(dq) == 0 or dq[-1] == j:
            dq.append(j)
        elif dq[-1] == '(' and j == ')':
            dq.pop()
    if len(dq) == 0:
        print('YES')
    else:
        print('NO')