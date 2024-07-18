import sys
from collections import deque

input = sys.stdin.readline

# 시험관 정보, 바이러스 번호 최댓값
N, K = map(int, input().strip().split())

graph = [list(map(int, input().strip().split())) for _ in range(N)]
S, X, Y = map(int, input().strip().split()) # S초 뒤에 X,Y에 존재하는 바이러스

temp_list = []

# 바이러스의 좌표들을 모두 추가
for i in range(N):
    for j in range(N):
        if graph[i][j] != 0:
            temp_list.append((graph[i][j], i, j))
            
virus_list = deque(sorted(temp_list))

time = 0

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 시간 S초까지 iteration
while time < S:
    
    # 바이러스 1번부터 K번까지 iteration
    for i in range(len(virus_list)):
        
        virus_num, row, col = virus_list.popleft()
        
        # 상하좌우 탐색
        for j in range(4):
            nx = dx[j] + row
            ny = dy[j] + col
            
            if 0 <= nx < N and 0 <= ny < N:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = virus_num
                    virus_list.append((virus_num, nx, ny))
    time += 1
    
print(graph[X-1][Y-1])