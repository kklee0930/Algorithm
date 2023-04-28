def solution(strArr):
    dic = {}
    for i in strArr:
        if len(i) not in dic:
            dic[len(i)] = 1
        else:
            dic[len(i)] += 1
    return max(dic.values())