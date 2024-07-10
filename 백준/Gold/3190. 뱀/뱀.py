import sys
from collections import deque

input = sys.stdin.readline

dir_info = {} # 방향 전환 정보 저장
snake = deque([[1, 1]]) # 뱀의 시작 좌표
time = 0 # 게임의 진행 시간
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
d = 0 # 방향전환 인덱스

n = int(input()) # 보드 정보
graph = [[None] * (n+1) for _ in range(n+1)]
graph[1][1] = 1 # 뱀의 시작 좌표

k = int(input()) # 사과 정보
for _ in range(k):
    y, x = map(int, input().split())
    graph[y][x] = 2
    
l = int(input()) # 방향 변환 정보
for _ in range(l):
    second, direction = input().split()
    dir_info[int(second)] = direction
    
y, x = 1, 1 # 시작점

while True:
    ny, nx = y + dy[d], x + dx[d] # 현재 방향에 따른 이동
    time += 1
    
    # 범위 벗어나면 종료
    if ny < 1 or nx < 1 or ny > n or nx > n or graph[ny][nx] == 1:
        break
    
    # 사과를 먹지 않는 경우 꼬리를 없애기
    if graph[ny][nx] != 2:
        tail = snake.popleft()
        y, x = tail[0], tail[1]
        graph[y][x] = 0
    
    y, x = ny, nx
    snake.append([y, x]) # 큐에 현재 뱀 좌표 추가
    graph[y][x] = 1
    
    # 전환할 방향 계산
    if time in dir_info.keys():
        if dir_info[time] == "D":
            d = (d+1) % 4
        else: # L일 경우
            nd = 3 if d == 0 else d - 1
            d = nd

print(time)