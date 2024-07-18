import sys
from collections import deque

input = sys.stdin.readline

# 시험관 정보, 바이러스 번호 최댓값
N, K = map(int, input().strip().split())

graph = [list(map(int, input().strip().split())) for _ in range(N)]
S, X, Y = map(int, input().strip().split()) # S초 뒤에 X,Y에 존재하는 바이러스

def bfs(r: int, c: int, virus: int):
    queue = deque([])
    queue.append((r, c))
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    row, col = queue.popleft()
    
    # 상하좌우 탐색
    for i in range(4):
        nx = dx[i] + row
        ny = dy[i] + col
        
        # 범위 체크
        if 0 <= nx < N and 0 <= ny < N:
            # 아직 감염되지 않았으면 감염처리
            if not graph[nx][ny]:
                graph[nx][ny] = virus
                visited[nx][ny] = 1
    return

# 시간 S초까지 iteration
for time in range(S):
    # 바이러스 1번부터 K번까지 iteration
    for i in range(1, K+1):
        # 전체 배열 iteration
        empty_space = 0 # 아직 감염시킬 공간이 남아있는지 체크
        visited = [[0] * (N) for _ in range(N)]
        for j in range(N):
            for k in range(N):
                # 해당 좌표에 바이러스 i가 있으면 bfs
                if graph[j][k] == i and not visited[j][k]:
                    bfs(j, k, i)
                    
                elif not graph[j][k]:
                    empty_space += 1
            
        if empty_space == 0: # 더 감염시킬 공간 없으면 바로 답 출력 후 종료
            answer = 0 if not graph[X-1][Y-1] else graph[X-1][Y-1]
            print(answer)
            sys.exit(0)
        
answer = 0 if not graph[X-1][Y-1] else graph[X-1][Y-1]
print(answer)