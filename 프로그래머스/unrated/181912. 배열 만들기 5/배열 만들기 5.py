def solution(intStrs, k, s, l):
    answer = []
    for int_ in intStrs:
        n = int(int_[s:s+l])
        if n > k:
            answer.append(n)
    return answer