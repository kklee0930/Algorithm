from collections import deque
import sys

input = sys.stdin.readline
N, M = map(int, input().strip().split()) # 노드 수, 간선 수

tree = [[] for _ in range(N+1)]
in_degree = [0] * (N+1) # 노드별 입력차수
answer = []

for _ in range(M):
    a, b = map(int, input().strip().split()) # a -> b 방향
    tree[a].append(b)
    in_degree[b] += 1 # b 노드의 입력차수++

queue = deque([])
for i in range(1, N+1): # 1부터 N까지 입력차수 0인 노드 큐에 추가
    if not in_degree[i]:
        queue.append(i)

while queue:
    curr = queue.popleft() # 현재 노드
    answer.append(curr)
    for i in tree[curr]: # 인접노드와 연결 끊기(간선 제거)
        in_degree[i] -= 1 # 연결 노드의 입력차수--
        if not in_degree[i]: # 입력차수가 0이 되면 큐에 추가
            queue.append(i)

print(*answer)