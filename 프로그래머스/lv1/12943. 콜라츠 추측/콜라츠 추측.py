def solution(num):
    cnt = 0
    while cnt < 500:
        if num == 1:
            return cnt
        cnt += 1
        if num % 2 == 0:
            num = num // 2
        else:
            num = (num*3) + 1
            
    return -1