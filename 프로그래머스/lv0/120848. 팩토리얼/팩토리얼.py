def solution(n):
    total = 1
    i = 0
    while total <= n:
        i += 1
        total *= i
    return i - 1