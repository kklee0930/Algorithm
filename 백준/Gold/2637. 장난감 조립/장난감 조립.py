import sys
from collections import deque

input = sys.stdin.readline

N = int(input()) # 완제품의 번호
M = int(input()) # 간선의 갯수
graph = [{} for _ in range(N+1)] # 부품 별 소요 부품
in_degree = [0] * (N+1) # 노드별 진입차수
needs = [[0] * (N+1) for _ in range(N+1)] # 각 부품별 기본 부품 소요 갯수

for _ in range(M):
    # X부품 만드는데 소요되는 Y부품은 K개
    X, Y, K = map(int, input().split())
    graph[Y][X] = K # Y부품으로 X부품을 만들기 위해서 K개가 소요
    in_degree[X] += 1
    
queue = deque([])

for i in range(1, N): # 완제품 빼고 iteration
    # 진입차수가 0이면 큐에 추가
    if not in_degree[i]:
        queue.append(i)
        
while queue:
    curr = queue.popleft()
    # key 만드는데에 소요되는 curr는 val개
    for key, val in graph[curr].items():
        if needs[curr].count(0) == N+1: # curr가 기본 부품인 경우
            needs[key][curr] += val
        else: # curr가 중간 부품인 경우
            for i in range(1, N+1):
                needs[key][i] += needs[curr][i] * val
        in_degree[key] -= 1
        
        # 연결 노드의 진입차수가 0이 되면 큐에 추가
        if not in_degree[key]:
            queue.append(key)
            
# 완제품 만들기 위한 각 기본 부품의 필요 갯수 출력
for i in range(1, N+1):
    if needs[N][i] > 0:
        print(i, needs[N][i])