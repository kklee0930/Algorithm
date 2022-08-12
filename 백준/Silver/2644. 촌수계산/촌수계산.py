import sys
input = sys.stdin.readline

node = int(input()) # 사람의 수
start, end = map(int,input().split()) # a와 b 사이의 촌수
vertex = int(input()) # 관계의 수
answer = [] # 답 출력용

graph = [[] for _ in range(node + 1)] # 인접 리스트
visited = [0] * (node + 1) # 방문 여부

# loop로 관계 입력받음
for _ in range(vertex):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

def dfs(start, count):
    # 방문했음을 기록
    count += 1
    visited[start] = 1
    
    # start와 end(목표지점)이 같으면 answer리스트에 append
    if start == end:
        answer.append(count)
    
    # 인접리스트의 인접 요소들을 확인하여 방문하지 않았으면 dfs 재귀
    for adj in graph[start]:
        if not visited[adj]:
            dfs(adj, count)

dfs(start, 0)

if len(answer) == 0:
    print(-1)
else:
    print(answer[0] - 1)