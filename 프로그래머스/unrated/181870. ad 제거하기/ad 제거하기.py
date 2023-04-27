def solution(strArr):
    answer = []
    for str_ in strArr:
        if 'ad' in str_:
            continue
        answer.append(str_)
    return answer