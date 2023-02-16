def solution(i, j, k):
    result = 0
    for num in range(i, j+1):
        if str(k) in str(num):
            result += str(num).count(str(k))
    return result