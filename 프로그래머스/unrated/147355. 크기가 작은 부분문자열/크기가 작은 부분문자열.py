def solution(t, p):
    answer = 0
    n = len(p)
    for i in range(len(t)-n+1):
        if int(t[i:i+n]) <= int(p):
            answer += 1
    return answer