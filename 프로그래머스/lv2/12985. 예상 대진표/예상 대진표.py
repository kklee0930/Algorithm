def solution(n,a,b):
    answer = 1
    a -= 1
    b -= 1
    while a // 2 != b // 2: # 같아지면 매칭이 됐다는 의미
        a = a // 2
        b = b // 2
        answer += 1
    return answer