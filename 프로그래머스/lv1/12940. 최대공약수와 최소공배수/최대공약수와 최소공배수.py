import copy
def solution(n, m):
    
    a, b = n, m
    
    while b:
        a, b = b, a % b
        
    GCD = a
    LCM = n * m // GCD
    answer = [GCD, LCM]
    
    return answer