import sys
input = sys.stdin.readline

# recursion(현재 노드, 노드 수, 현재 거리 합)
def recursion(start: int, current:int, depth: int, cost: int):
    global min_val
    
    # 방문이 n번보다 많아지거나 기존 최소값보다 커지거나 이미 방문한 노드인 경우 return
    if cost >= min_val:
        return
    
    # 경로 끝 도달할 경우 최솟값 갱신
    if depth == n:
        if dist[current][start] != 0:
            min_val = min(min_val, cost + dist[current][start])
        return
    
    # 해당 노드와 연결된 노드 중 방문하지 않은 노드면 재귀
    for i in range(n):
        if visited[i] == 1 or dist[current][i] == 0:
            continue
        
        visited[i] = 1
        recursion(start, i, depth + 1, cost + dist[current][i])
        visited[i] = 0

n = int(input())
dist = []
visited = [0] * n
min_val = sys.maxsize

for _ in range(n):
    dist.append(list(map(int, input().split())))

for i in range(n):
    visited[i] = 1
    recursion(i, i, 1, 0)
    visited[i] = 0
print(min_val)