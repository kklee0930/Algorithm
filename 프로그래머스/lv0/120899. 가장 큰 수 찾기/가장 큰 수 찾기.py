def solution(array):
    max_ = max(array)
    idx = array.index(max_)
    answer = [max_, idx]
    return answer