import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]

for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 0
def dfs(node: int):
    for n in graph[node]:
        if not visited[n]:
            visited[n] = 1
            dfs(n)

for num in range(1, n + 1):
    if not visited[num]:
        visited[num] = 1
        cnt += 1
        dfs(num)
        
print(cnt)