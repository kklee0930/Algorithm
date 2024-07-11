import sys
input = sys.stdin.readline

n = int(input())
num = n
cnt = 0

while True:
    # 몫, 나머지, 몫+나머지 의 나머지 구해서 계산
    a = num // 10
    b = num % 10
    c = (a + b) % 10
    
    num = 10 * b + c
    cnt += 1
    if num == n:
        break
print(cnt)