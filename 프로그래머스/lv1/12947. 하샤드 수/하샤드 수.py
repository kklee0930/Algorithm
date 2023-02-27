def solution(x):
    # 자릿수합 = sum(map(int, str(x)))
    # 나누어 떨어지다 = x % sum(map(int, str(x))) == 0
    n = sum(map(int, str(x)))
    if x % n == 0:
        return True
    else:
        return False