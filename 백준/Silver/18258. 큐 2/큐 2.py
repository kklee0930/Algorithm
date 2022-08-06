from collections import deque
from sys import stdin
queue = deque()
for _ in range(int(stdin.readline())):
    cmd = stdin.readline().split()
    
    if 'push' in cmd:
        queue.append(cmd[1])

    elif 'pop' in cmd:
        if queue:
            print(queue.popleft())
        else:
            print(-1)

    elif 'size' in cmd:
        print(len(queue))

    elif 'empty' in cmd:
        if queue:
            print(0)
        else:
            print(1)

    elif 'front' in cmd:
        if queue:
            print(queue[0])
        else:
            print(-1)
    
    elif 'back' in cmd:
        if queue:
            print(queue[-1])
        else:
            print(-1)