def solution(s):
    list_ = s.split(' ')
    list_ = list(map(int, list_))
    result = list(map(str, [min(list_), max(list_)]))
    answer = ' '.join(result)
    return answer