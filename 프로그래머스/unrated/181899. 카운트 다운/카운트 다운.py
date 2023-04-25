def solution(start, end):
    answer = []
    for n in range(start, end-1, -1):
        answer.append(n)
    return answer