import sys, heapq as hq

input = sys.stdin.readline

# 정점의 갯수, 간선의 갯수
vertex, edge = map(int, input().strip().split())

# 시작점
start = int(input())

graph = [[] for _ in range(vertex+1)]
dp = [sys.maxsize] * (vertex+1)
visited = [0] * (vertex+1)

for _ in range(edge):
    # u에서 v로 가는 간선의 가중치 w
    u, v, w = map(int, input().strip().split())
    
    graph[u].append([v, w])
    
def dijkstra(start):
    pq = []
    hq.heappush(pq, (0, start))
    dp[start] = 0
    
    while pq:
        cost, node = hq.heappop(pq)
        visited[node] = 1
        
        # 인접노드 탐색
        for adj_node in graph[node]:
            # 인접 노드의 번호, 현재 노드에서 인접한 노드까지의 가중치
            num, weight = adj_node[0], adj_node[1]
            if visited[num]: continue # 방문했을 시 continue
            new_distance = cost + weight
            
            # 신규 거리가 기존 거리보다 짧으면 갱신
            if new_distance < dp[num]:
                dp[num] = new_distance
                hq.heappush(pq, (new_distance, num))
    return

dijkstra(start)

for i in range(1, vertex+1):
    if not visited[i]:
        print("INF")
        continue
    print(dp[i])