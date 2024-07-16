import sys

input = sys.stdin.readline

n = int(input().strip()) # 노드의 갯수
a = input().strip() # 실외/실내 여부

inside = [0] * (n+1) # 노드의 실외/실내 여부
graph = [[] for _ in range(n+1)]

for i in range(len(a)):
    inside[i+1] = int(a[i])

for _ in range(3, n+2):
    # 두 노드 사이의 간선 저장
    u, v = map(int, input().strip().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 0

def dfs(start, visited):
    global cnt
    
    # 인접노드 탐색
    for adj_node in graph[start]:
        
        # 방문하지 않은 노드만 탐색
        if visited[adj_node]:
            continue
        visited[adj_node] = 1
        
        # 방문하지 않은 노드이고 실내이면 경로++
        if inside[adj_node]:
            cnt += 1
            continue
        dfs(adj_node, visited) # 야외면 재귀(계속 탐색)
    return

for i in range(1, n+1):
    if not inside[i]: # 실내에서만 출발
        continue
    visited = [0] * (n+1) # 노드의 방문여부
    visited[i] = 1
    dfs(i, visited)

print(cnt)