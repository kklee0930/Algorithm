from collections import deque

N = int(input())
deque = deque()
for i in range(N, 0, -1):
    deque.append(i)

while len(deque) != 1:
    deque.pop()
    if len(deque) == 2:
        deque.reverse()
    else:
        deque.insert(0,deque[-1])
        deque.pop()
        
if len(deque) == 1:
    print(deque.pop())