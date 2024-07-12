import sys
from collections import deque
input = sys.stdin.readline

t = int(input()) # 테케 갯수

# bfs(정점, 정점 구분하기 위한 값: 1,-1)
def bfs(node: int, color: int):
    global is_bipartite
    
    queue = deque([])
    queue.append((node, color))
    visited[node] = 1
    
    while queue:
        node, color = queue.popleft()
        # 현재 정점과 연결된 정점 순회
        for vertex in graph[node]:
            # 현재 정점 색깔과 인접 정점 색깔이 같으면 이분 그래프가 아님
            if color == vertex_color[vertex]:
                is_bipartite = 0
                return
            # 인접 정점의 색깔을 현재 정점 색깔과 다르게 설정
            if not visited[vertex]:
                vertex_color[vertex] = -1 * color
                visited[vertex] = 1
                queue.append((vertex, vertex_color[vertex]))
                
    is_bipartite = 1
    return

for _ in range(t):
    v,e = map(int, input().split()) # vertex, edge
    graph = [[] for _ in range(v+1)]
    vertex_color = [0] * (v+1) # 정점 별 집합 구분 위한 배열
    visited = [0] * (v+1) # 정점 별 방문 여부 확인
    is_bipartite = 1 # 이분 그래프 여부
    
    for _ in range(e):
        u, v = map(int, input().split())
        graph[u].append(v) # 양방향 그래프
        graph[v].append(u)

    for i in range(1, v+1):
        if not visited[i]:
            bfs(i, -1)
        if not is_bipartite:
            break
        
    answer = "NO" if not is_bipartite else "YES"
    print(answer)