def solution(n):
    # 4, 3, 3, 2, 2, 1, 1 (n, n-1, n-1, n-2, n-2, 1, 1)
    arr = [[0] * n for _ in range(n)]
    trans = 1
    cnt = 1
    r, c = 0, -1
    
    while n > 0:
        for _ in range(n):
            c += trans
            arr[r][c] = cnt
            cnt += 1
            
        n -= 1
        
        for _ in range(n):
            r += trans
            arr[r][c] = cnt
            cnt += 1
            
        trans *= -1
        
    return arr