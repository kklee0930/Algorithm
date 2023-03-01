def solution(n):
    if n % 2 == 0:
        return n // 2 * '수박'
    else:
        return n // 2 * '수박' + '수'