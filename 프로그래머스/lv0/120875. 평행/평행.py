def solution(dots):
    answer = 0
    result = []
    # 직선 기울기 구하기 = y 증가량 / x 증가량
    if abs(dots[0][0] - dots[1][0]) / abs(dots[0][1] - dots[1][1]) == abs(dots[2][0] - dots[3][0]) / abs(dots[2][1] - dots[3][1]):
        return 1
    if abs(dots[0][0] - dots[2][0]) / abs(dots[0][1] - dots[2][1]) == abs(dots[1][0] - dots[3][0]) / abs(dots[1][1] - dots[3][1]):
        return 1
    if abs(dots[0][0] - dots[3][0]) / abs(dots[0][1] - dots[3][1]) == abs(dots[1][0] - dots[2][0]) / abs(dots[1][1] - dots[2][1]):
        return 1
    
    return answer