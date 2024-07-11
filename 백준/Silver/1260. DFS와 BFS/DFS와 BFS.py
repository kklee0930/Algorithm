import sys
from collections import deque
input = sys.stdin.readline

def dfs(x: int):
    print(x, end=" ")
    
    visited[x] = 1
    nodes = graph[x]
    
    # 방문하지 않은 경우에 재귀
    for n in nodes:
        if not visited[n]:
            dfs(n)
    
def bfs(x: int):
    queue = deque([x])
    visited[x] = 1
    
    while queue:
        curr = queue.popleft()
        print(curr, end=" ")
        nodes = graph[curr]
        # 방문하지 않은 경우 순차적으로 큐에 추가
        for n in nodes:
            if not visited[n]:
                queue.append(n)
                visited[n] = 1

n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    # 양방향 그래프이기 때문에 양쪽으로 추가
    graph[a].append(b)
    graph[b].append(a)

# 꼭 정렬 해줘야함.
for i in range(len(graph)):
    graph[i].sort()
    
# visited 초기화
visited = [0] * (n + 1)
dfs(v)
print()
visited = [0] * (n + 1)
bfs(v)