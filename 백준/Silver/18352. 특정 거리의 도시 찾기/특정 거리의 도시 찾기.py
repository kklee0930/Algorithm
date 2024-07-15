from collections import deque
import sys

input = sys.stdin.readline

# 노드 갯수, 간선 갯수, 최단거리, 출발 노드
n, m, k, x = map(int, input().strip().split())

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
dist = [0] * (n+1)

# 연결되어 있는 단방향 인접 노드 u, v
for _ in range(m):
    u, v = map(int, input().strip().split())
    graph[u].append(v)
    
def bfs(node: int, cnt: int):
    queue = deque([])
    queue.append((node, cnt))
    
    while queue:
        # 현재 노드, 거리
        node, cnt = queue.popleft()
        
        # 해당 노드와 연결된 인접 노드 탐색
        for num in graph[node]:
            if not visited[num]:
                visited[num] = 1
                dist[num] = cnt
                queue.append((num, cnt+1))
    return

visited[x] = 1
bfs(x, 1)

flag = False
for i in range(1, n+1):
    if dist[i] == k:
        print(i)
        flag = True
if not flag:
    print(-1)