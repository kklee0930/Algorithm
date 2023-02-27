def solution(a, b):
    answer = 0
    l = [a,b]
    for num in range(min(l), max(l)+1):
        answer += num
    return answer