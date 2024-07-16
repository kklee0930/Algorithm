import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

n = int(input().strip()) # 노드의 갯수
a = input().strip() # 실외/실내 여부

inside = [0] * (n+1) # 노드의 실외/실내 여부
visited = [0] * (n+1) # 노드의 방문여부
graph = [[] for _ in range(n+1)]

for i in range(len(a)):
    inside[i+1] = int(a[i])

# 서브태스크 1번: 모두 실외이면 산책로가 없으므로 0
if not inside:
    print(0)
    sys.exit(0)
    
for _ in range(3, n+2):
    # 두 노드 사이의 간선 저장
    u, v = map(int, input().strip().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(start): # 시작노드는 실외
    
    temp = 0 # 실외와 연결된 실내 노드 개수
    
    # 인접노드 탐색
    for adj_node in graph[start]:
        
        # 다음 노드가 야외
        if not inside[adj_node]:
            # 미방문 노드인 경우
            if not visited[adj_node]:
                visited[adj_node] = 1 # 방문처리
                temp += dfs(adj_node) # 재귀
                
        else: # 실내인 경우 실외와 연결된 실내 노드 개수++
            temp += 1
    return temp

cnt = 0
for i in range(1, n+1):
    
    if not inside[i]: # 실외인경우
        if not visited[i]: # 미방문인 경우 방문처리 후 dfs
            visited[i] = 1
            temp = dfs(i)
            # 실외와 연결된 실내 개수(temp) * temp에서 자신을 뺀(temp-1)
            cnt += temp * (temp-1)
            
    else: # 실내일 경우엔 바로 인접한 노드가 실내인지만 체크
        for adj_node in graph[i]: # 인접노드 탐색
            if inside[adj_node]: # 인접노드가 실내면 경로++
                cnt += 1

print(cnt)