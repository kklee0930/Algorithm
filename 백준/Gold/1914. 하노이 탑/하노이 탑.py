import sys

# 옮길 원판의 갯수, 시작지점, 목표지점
def hanoi(n, s, e):
        
    global cnt
    cnt += 1

    if n > 1:
        hanoi(n - 1, s, 6 - s - e)

    print(s, e)
    
    if n > 1:
        hanoi(n - 1, 6 - s - e, e)
    
N = int(sys.stdin.readline())
cnt = 0
print(2**N-1)
if N <= 20:
    hanoi(N, 1, 3)