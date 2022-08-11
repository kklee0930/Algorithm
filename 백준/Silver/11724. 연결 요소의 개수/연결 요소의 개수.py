import sys
sys.setrecursionlimit(10000)  
input = sys.stdin.readline

def dfs(node):
    visited[node] = 1
    for i in graph[node]:
        if not visited[i]:
            dfs(i)

# 정점과 간선 입력 받음
node, vertex = map(int, input().split())

# 방문여부확인을 위한 리스트 생성(인덱스로 접근할 것이기 때문에 node + 1 곱)
visited = [0] * (node + 1)

# 마찬가지로 node + 1 곱
graph = [[] for _ in range(node+1)]

count = 0

for _ in range(vertex):
    v1,v2 = map(int,input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(1, node+1):
    if not visited[i]:
        dfs(i)
        count += 1
print(count)