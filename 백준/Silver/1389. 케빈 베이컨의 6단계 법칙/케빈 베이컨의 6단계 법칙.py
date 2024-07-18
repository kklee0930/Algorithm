import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().strip().split()) # 노드 수, 간선 수
graph = [[] for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, input().strip().split())
    graph[A].append(B)
    graph[B].append(A)
    
def floyd_warshall(node: int):
    queue = deque([])
    bacon = [0] * (N+1) # 노드 별 케빈 베이컨 값
    queue.append((node, 1))
    
    while queue:
        node, cnt = queue.popleft()
        for n in graph[node]:
            if not bacon[n]: # 케빈 베이컨 값이 없으면 cnt로 설정
                bacon[n] = cnt
                queue.append((n, cnt+1))
    return sum(bacon)

answer = []
for i in range(1, N+1):
    answer.append([i, floyd_warshall(i)]) # 사람의 번호, 베이컨 값

# 베이컨 값, 사람의 번호로 정렬
answer.sort(key=lambda x: (x[1], x[0]))
print(answer[0][0])