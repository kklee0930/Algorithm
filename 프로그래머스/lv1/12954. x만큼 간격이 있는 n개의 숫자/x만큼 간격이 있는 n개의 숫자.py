def solution(x, n):
    answer = []
    # for i in range(x, x**(n+1) , x):
    #     answer.append(i)
    #     if len(answer) == n:
    #         break
    num = 0
    for _ in range(n):
        num += x
        answer.append(num)
    return answer