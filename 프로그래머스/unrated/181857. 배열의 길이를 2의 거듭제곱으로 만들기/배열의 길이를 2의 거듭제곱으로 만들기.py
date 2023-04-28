def solution(arr):
    cnt = 0
    while True:
        n = 2 ** cnt
        if n >= len(arr):
            arr.extend([0] * (n - len(arr)))
            return arr
        else:
            cnt += 1