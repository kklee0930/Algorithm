import sys
input = sys.stdin.readline

com = int(input()) # 컴퓨터 대수
pair = int(input()) # 컴퓨터 쌍
graph = [[] for _ in range(com+1)]
visited = [0] * (com+1)
cnt = 0

def dfs(n: int):
    global cnt
    for num in graph[n]:
        if visited[num] == 0:
            visited[num] = 1
            cnt += 1
            dfs(num)
    return

for _ in range(pair):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited[1] = 1
dfs(1)
print(cnt)