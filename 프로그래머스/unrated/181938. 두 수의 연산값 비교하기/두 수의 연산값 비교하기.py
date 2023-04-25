def solution(a, b):
    ab = int(str(a) + str(b))
    ab2 = 2 * a * b
    return max(ab, ab2)