def solution(n):
    trit = ''
    answer = 0
    
    while n > 0:
        num = n % 3
        n = n // 3
        trit += str(num)
        
    cnt = 0 # 3의 지수
    for i in range(len(trit)-1, -1, -1): # trit iteration
        answer += int(trit[i]) * (3**cnt)
        cnt += 1
        
    return answer
        