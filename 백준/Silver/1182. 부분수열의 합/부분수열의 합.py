import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
def solution(idx: int, _sum: int):
    global cnt
    
    # 현재 부분수열의 길이가 n보다 커지면 중단
    if idx >= n:
        return
    
    # 기존 부분 수열의 합 + 현재 배열 인덱스 값
    _sum += arr[idx]
    
    # 부분 수열 합이 s와 같으면 갯수++
    if _sum == s:
        cnt += 1
    
    # 배열의 현재 값을 포함하는 경우와 아닌 경우로 나누어 재귀
    solution(idx+1, _sum)
    solution(idx+1, _sum - arr[idx])

solution(0, 0)
print(cnt)