import sys, heapq

input = sys.stdin.readline

n = int(input().strip()) # 노드의 갯수
m = int(input().strip()) # 간선의 갯수
graph = [[] for _ in range(n+1)] # {v: c}
dp = [sys.maxsize] * (n+1) # 노드별 최소비용

for _ in range(m):
    # 노드 u에서 노드 v까지의 거리 c
    u, v, c = map(int, input().strip().split())
    graph[u].append((v, c))

def dijkstra(start: int):
    pq = []
    # 시작노드 비용 0으로 설정
    dp[start] = 0
    heapq.heappush(pq, [0, start])
    
    while pq:
        # 현재 노드
        cost, curr = heapq.heappop(pq)
        if dp[curr] < cost:
            continue
        
        # 현재 노드와 연결된 노드 탐색
        for key, value in graph[curr]:
            new_cost = dp[curr] + value
            
            # (현재노드 최단거리 + 연결노드까지 거리)가 연결노드의 최소비용보다 작으면 갱신
            if new_cost < dp[key]:
                dp[key] = new_cost
                heapq.heappush(pq, [new_cost, key])
    return

# 시작점, 도착점
dep, dest = map(int, input().strip().split())
dijkstra(dep)
print(dp[dest])