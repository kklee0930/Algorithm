node = int(input()) # node 갯수
vertex = int(input()) # vertex 갯수
graph = [[] for i in range(node + 1)]
visited = [0] * (node + 1)
# 인접 리스트 만들기
for _ in range(vertex): # vertex 갯수만큼 loop
    v1, v2 = map(int, input().split()) # 서로 연결된 node이므로
    # 각 노드의 리스트에 값을 저장
    graph[v1].append(v2)
    graph[v2].append(v1)

# 1번 컴퓨터를 시작 노드로 DFS 진행
def dfs(start):
    stack = [start]
    visited[start] = 1
    
    while stack: 
        current = stack.pop()

        for adj in graph[current]: 
            if not visited[adj]: 
                visited[adj] = 1
                stack.append(adj)
    return sum(visited) - 1
print(dfs(1))