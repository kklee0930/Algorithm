def solution(n):
    d = [0] * (n+1)
    
    def Get_fibonacci(n):
        d[0], d[1] = 0, 1
        for i in range(2, n+1):
            d[i] = d[i-2] + d[i-1]
        
        return d[n]
    
    answer = Get_fibonacci(n) % 1234567
    return answer