def solution(array, n):
    dict_ = {}
    answer = []
    for num in array:
        dict_[num] = abs(num-n)
    min_val = min(dict_.values())
    for num, abs_val in dict_.items():
        if abs_val == min_val:
            answer.append(num)
    return min(answer)