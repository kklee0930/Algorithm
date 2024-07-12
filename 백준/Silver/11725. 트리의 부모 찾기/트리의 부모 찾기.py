import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

parent_dict = {}

def bfs(node: int, parent: int):
    visited = [0] * (n+1)
    queue = deque([])
    queue.append((node, parent))
    
    while queue:
        curr_node, parent_node = queue.popleft()
        adj_nodes = tree[curr_node]
        
        for num in adj_nodes:
            if not visited[num]:
                visited[num] = 1
                parent_dict[num] = curr_node
                queue.append((num, curr_node))
    return
  
bfs(1, 1)
for i in range(2, n+1):
    print(parent_dict[i])