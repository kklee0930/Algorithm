import sys
from collections import deque

dq = deque()

T = int(input())
for tc in range(1, T+1):
    cmd = list(sys.stdin.readline().split())

    if 'push_front' in cmd:
        dq.appendleft(cmd[1])
        
    elif 'push_back' in cmd:
        dq.append(cmd[1])
        
    elif 'pop_front' in cmd:
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.popleft())
            
    elif 'pop_back' in cmd:
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.pop())
            
    elif 'size' in cmd:
        print(len(dq))
        
    elif 'empty' in cmd:
        if len(dq) == 0:
            print(1)
        else:
            print(0)
            
    elif 'front' in cmd:
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
            
    elif 'back' in cmd:
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[-1])