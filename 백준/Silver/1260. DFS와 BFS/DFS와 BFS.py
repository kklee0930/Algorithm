from collections import deque

node, vertex, start = map(int, input().split())

visited = [0] * (node + 1)

adjacent = [[] for _ in range(node+1)]

for i in range(vertex):
    a,b = map(int, input().split())
    adjacent[a].append(b)
    adjacent[b].append(a)

for i in range(len(adjacent)):
    adjacent[i].sort()

def dfs(start):
    print(start, end=' ')  
    visited[start] = 1
    for i in adjacent[start]:
        if not visited[i]:
            dfs(i)

def bfs(start):
    queue = deque([start]) #queue 생성
    visited[start] = 1 # start지점을 visited 처리
    while queue: # queue가 빌때까지
        current = queue.popleft() # 왼쪽 요소를 current
        print(current, end=' ')
        for i in adjacent[current]:
            if not visited[i]:
                queue.append(i)
                visited[i] = 1
            
dfs(start)
visited = [0] * (node + 1)
print()
bfs(start)