def solution(num_list):
    a, b = 0, 0
    for i in range(len(num_list)):
        if i % 2 == 0:
            a += num_list[i]
        else:
            b += num_list[i]
    return max(a, b)