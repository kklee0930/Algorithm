import sys
from collections import deque

queue = deque()

def cmd_executor(cmd : list):
    global queue
    match cmd[0]:
        case "push":
            queue.append(cmd[1])
            
        case "pop":
            if not queue:
                print(-1)
            else:
                print(queue.popleft())
                
        case "size":
            print(len(queue))
            
        case "empty":
            if not queue:
                print(1)
            else:
                print(0)
                
        case "front":
            if not queue:
                print(-1)
            else:
                print(queue[0])

        case "back":
            if not queue:
                print(-1)
            else:
                print(queue[-1])

for _ in range(int(sys.stdin.readline())):
    input_ = sys.stdin.readline().strip().split()
    cmd_executor(input_)