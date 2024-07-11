import sys
input = sys.stdin.readline

# 2차원 배열의 크기
n = int(input())

graph = [list(map(int, input().strip())) for _ in range(n)]
    
def recursion(r: int, c: int, d: int):
    init_num = graph[r][c] # 시작 숫자

    # 더이상 나눌 수 없으면 출력
    if d == 1:
        print(init_num, end="")
        return
    
    for i in range(r, r+d):
        for j in range(c, c+d):
            if graph[i][j] != init_num:
                print('(', end="") # 재귀 시 여는 괄호 추가
                d //= 2
                recursion(r, c, d)
                recursion(r, c+d, d)
                recursion(r+d, c, d)
                recursion(r+d, c+d, d)
                print(')', end="") # 재귀 끝나면 닫는 괄호 추가
                return
    
    if init_num == 1:
        print(1, end="")
    else:
        print(0, end="")
recursion(0, 0, n)