def solution(a, b):
    a_divisor = []
    b_divisor = []
    # a 약수
    for i in range(1, a+1):
        if a % i == 0:
            a_divisor.append(i)
    # b 약수
    for j in range(1, b+1):
        if b % j == 0:
            b_divisor.append(j)
    
    for i in range(len(a_divisor)-1, -1, -1):
        if a_divisor[i] in b_divisor:
            GCD = a_divisor[i] # 최대공약수
            break
            
    a /= GCD
    b /= GCD
    
    while b > 1:
        if b % 5 == 0:
            b = b // 5
            pass
        elif b % 2 == 0:
            b = b // 2
            pass
        else:
            return 2
    return 1