def solution(n):
    answer = ''
    if n <= 3:
        if n == 3:
            return '4'
        else:
            return str(n)
    while n > 3:
        if n % 3 == 0:
            div = n//3 - 1 # 몫
            rem = n - (3*div)
            if rem == 3:
                answer += '4'
            else:
                answer += str(rem)
            n = div
        else:
            answer += str(n % 3)
            n = n // 3
    if n == 3:
        answer += '4'
    else:
        answer += str(n)
    return answer[::-1]