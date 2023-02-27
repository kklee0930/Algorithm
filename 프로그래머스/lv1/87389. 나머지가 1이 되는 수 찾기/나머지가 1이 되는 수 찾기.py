def solution(n):
    for num in range(2, n):
        if n % num == 1:
            return num
    return n - 1