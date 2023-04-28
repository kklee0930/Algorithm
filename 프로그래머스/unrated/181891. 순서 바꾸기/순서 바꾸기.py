def solution(num_list, n):
    a, b = num_list[0:n], num_list[n:]
    b.extend(a)
    return b