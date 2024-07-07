import sys

def n_queen(col : int):
    global n, cnt
    
    if col == n:
        cnt += 1
        return

    # i는 열
    for i in range(n):
        # 열이 겹치지 않고 y=x 대각이 겹치지 않고 y=-x대각이 겹치지 않을 경우에만 재귀
        if not visited_c[i] and not visited_up[i + col] and not visited_down[(n-1)+col-i]:
            visited_c[i], visited_up[i + col], visited_down[(n-1)+col-i] = True, True, True
            n_queen(col+1)
            visited_c[i], visited_up[i + col], visited_down[(n-1)+col-i] = False, False, False
            
n = int(sys.stdin.readline())

graph =[[0]*n for _ in range(n)]
# 열 중복 여부
visited_c = [False] * n
# y = x 대각 중복 여부
visited_up = [False] * (2*(n-1)+1)
# y = -x 대각 중복 여부
visited_down = [False] * (2*(n-1)+1)

cnt = 0
n_queen(0)
print(cnt)