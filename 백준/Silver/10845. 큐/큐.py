from queue import Queue
import sys

T = int(input())
queue = Queue()

for tc in range(1, T+1):
    cmd = list(sys.stdin.readline().split())
    
    if 'push' in cmd:
        queue.put(cmd[1])
        
    elif 'front' in cmd:
        if queue.empty() == True:
            print(-1)
        else:
            print(queue.queue[0])

    elif 'back' in cmd:
        if queue.empty() == True:
            print(-1)
        else:
            print(queue.queue[-1])

    elif 'size' in cmd:
        print(queue.qsize())
    
    elif 'empty' in cmd:
        if queue.empty() == True:
            print(1)
        else:
            print(0)
    
    elif 'pop' in cmd:
        if queue.empty() == True:
            print(-1)
        else:
            print(queue.get())