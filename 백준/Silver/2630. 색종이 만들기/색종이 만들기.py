import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
w, b = 0, 0

def recursion(x: int, y: int, N: int):
    global w, b
    
    color = graph[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if graph[i][j] != color:
                recursion(x, y, N//2)
                recursion(x, y+N//2, N//2)
                recursion(x+N//2, y, N//2)
                recursion(x+N//2, y+N//2, N//2)
                return
    if color == 0:
        w += 1
    else:
        b += 1

recursion(0, 0, n)
print(w)
print(b)