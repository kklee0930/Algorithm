import math
def solution(n, stations, w):
    end = 0
    leng = []
    for s in stations:
        if s-w-1 > end:
            leng.append(s-w-1-end)
        end = s+w
    if end < n:
        leng.append(n-end)
    
    div = 1+(w*2) # 기지국 커버 거리
    answer = 0
    for l in leng:
        if div >= l:
            answer += 1
        else:
            answer += math.ceil(l/div)
    return answer
    
        