import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
queue = deque(i for i in range(1, N+1))
answer = list()

while queue:
    for i in range(K):
        n = queue.popleft()
        if i != K - 1:
            queue.append(n)
        else:
            answer.append(str(n))
            
print(f"<{', '.join(answer)}>")