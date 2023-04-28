def solution(n):
    answer = []
    for i in range(n):
        li = [0] * n
        li[i] = 1
        answer.append(li)
    return answer