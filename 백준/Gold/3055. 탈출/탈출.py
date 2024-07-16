from collections import deque
import sys

input = sys.stdin.readline

R, C = map(int, input().strip().split())
graph = [list(input().strip()) for _ in range(R)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
time = 0 # 고슴도치가 굴까지 도달하기까지 소요되는 시간
visited = [[0] * C for _ in range(R)] # 방문여부 배열
temp = [] # 홍수 시작 좌표 담기 위한 배열

for i in range(R):
    for j in range(C):
        # 빈 땅과 홍수 시작지점을 각각 maxsize, 0으로 치환
        if graph[i][j] == ".":
            graph[i][j] = sys.maxsize
        elif graph[i][j] == "*":
            graph[i][j] = 0
            temp.append([i, j])
        elif graph[i][j] == "S": # 고슴도치 시작지점
            start = [i, j]
            
def bfs(row, col):
    queue = deque([])
    queue.append((row, col, 0))
    visited[row][col] = 1
    
    while queue:
        r, c, time = queue.popleft()
        
        for i in range(4):
            nx = dx[i] + r
            ny = dy[i] + c
            
            if 0 <= nx < R and 0 <= ny < C: # 범위체크
                if graph[nx][ny] in ("X", "S"): # 타입에러 방지 위해 체크
                    continue
                if graph[nx][ny] == "D": # 비버의 굴에 도착하면
                    return time+1
                # 해당 좌표의 물이 도달하는 시간보다 고슴도치가 더 빠르고 미방문 시
                elif graph[nx][ny] > time+1 and not visited[nx][ny]:
                    visited[nx][ny] = 1
                    queue.append((nx, ny, time+1))
    return "KAKTUS"

def flood(row, col):
    queue = deque([])
    queue.append((row, col, 0))
    
    while queue:
        r, c, time = queue.popleft()
        
        for i in range(4):
            nx = dx[i] + r
            ny = dy[i] + c
            
            if 0 <= nx < R and 0 <= ny < C: # 범위체크
                if graph[nx][ny] in ["X", "S", "D"]: # 타입에러 방지위해 체크
                    continue
                # 그래프에 물이 언제 도달하는지 시간으로 나타내기
                if graph[nx][ny] > time+1: # 좌표 시간값이 현재 시간값보다 크면 갱신
                    graph[nx][ny] = time+1
                    queue.append((nx, ny, time+1))
    return

# 그래프 전체를 먼저 홍수 처리
for li in temp:
    flood(li[0], li[1])
    
print(bfs(start[0], start[1]))