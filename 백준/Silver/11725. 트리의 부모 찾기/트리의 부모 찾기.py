import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

# 각 노드의 부모 노드 저장하는 dictionary
parent_dict = {}

def bfs(node: int):
    visited = [0] * (n+1) # 방문여부
    queue = deque([])
    queue.append(node) # 노드 자기자신, 해당 노드의 부모 노드
    
    while queue:
        curr_node = queue.popleft()
        adj_nodes = tree[curr_node] # 현재 노드와 인접한 노드들
        
        # 인접 노드 iteration 통해 탐색
        for num in adj_nodes:
            # 루트에서 탐색을 시작하기 때문에 현재 노드가 부모 노드가 됨
            if not visited[num]:
                visited[num] = 1
                parent_dict[num] = curr_node
                queue.append(num)
    return

bfs(1)
for i in range(2, n+1):
    print(parent_dict[i])