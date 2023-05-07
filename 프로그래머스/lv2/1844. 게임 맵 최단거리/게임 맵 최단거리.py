from collections import deque
def solution(maps):
    n, m = len(maps)-1, len(maps[0])-1
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    queue = deque([])
    
    queue.append([0,0])
    
    while queue:
        curr = queue.popleft()
        x = curr[0]
        y = curr[1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx <= n and 0 <= ny <= m and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append([nx, ny])
                
    goal = maps[n][m]
    
    if goal == 1:
        return -1
    else:
        return goal