from collections import deque
def solution(x, y, n):
    def bfs(x, y, n):
        queue = deque()
        v[x] = 1
        queue.append(x)
    
        while queue: # bfs
            if v[y] == True:
                break
            x = queue.popleft()
            if 0 <= x * 2 <= 1000000 and v[x*2] == 0:
                v[x*2] = v[x] + 1 # 연산횟수 카운트
                queue.append(x*2)
            if 0 <= x * 3 <= 1000000 and v[x*3] == 0:
                v[x*3] = v[x] + 1
                queue.append(x*3)
            if 0 <= x + n <= 1000000 and v[x+n] == 0:
                v[x+n] = v[x] + 1
                queue.append(x+n)
                
    v = [0] * 1000001
    bfs(x, y, n)
    return v[y]-1