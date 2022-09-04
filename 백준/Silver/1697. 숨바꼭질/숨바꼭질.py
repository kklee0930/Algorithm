from collections import deque

N, K = map(int, input().split())

def bfs():
    queue = deque()
    queue.append(N)
    
    while queue:
        curr = queue.popleft()
        if curr == K:
            return time[curr]
        for next_step in (curr + 1, curr - 1, curr * 2):
            if 0 <= next_step < max_ and not time[next_step]:
                time[next_step] = time[curr] + 1
                queue.append(next_step)
            
max_ = 100001
time = [0] * max_
print(bfs())