def solution(n):
    cnt = 0
    for decimal in range(1, n+1):
        while True:
            cnt += 1
            if cnt % 3 == 0 or '3' in str(cnt):
                pass
            else:
                break
    return cnt
