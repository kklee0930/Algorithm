def solution(n):
    answer = 0
    for i in range(1, n + 1):
        temp = []
        for j in range(1, i + 1):
            if i % j == 0:
                temp.append(i)
        if len(list(temp)) >= 3:
            answer += 1
    return answer