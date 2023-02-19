def solution(slice, n):
    for i in range(1, 51):
        if i * slice >= n:
            return i