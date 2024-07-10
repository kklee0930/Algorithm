import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())
    
def solution(a: int, b: int, c: int):
    if b == 0: # 재귀의 끝(b가 0이 되면 1 리턴)
        return 1
    if b % 2 == 1: # 홀수일 경우 a^b = a * a^(b-1)
        return a * solution(a, b-1, c) % c
    temp = solution(a, b//2, c) % c # 짝수일 경우 a^(b/2) * a^(b/2)
    return temp * temp % c # a^(b/2) * a^(b/2)

print(solution(a,b,c))