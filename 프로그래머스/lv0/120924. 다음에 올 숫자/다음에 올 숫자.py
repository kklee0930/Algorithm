def solution(common):
    # 등차수열일 경우
    if abs(common[1] - common[0]) == abs(common[2] - common[1]):
        n = common[1] - common[0]
        answer = common[-1] + n
    # 등비수열일 경우
    elif abs(common[1] / common[0]) == abs(common[2] / common[1]):
        n = common[1] / common[0]
        answer = common[-1] * n
    return answer