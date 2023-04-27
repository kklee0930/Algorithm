def solution(a, d, included):
    answer = 0
    cnt = 0
    for i in range(len(included)):
        if i == 0:
            cnt = a
        else:
            cnt += d
        if included[i] == True:
            answer += cnt
    return answer