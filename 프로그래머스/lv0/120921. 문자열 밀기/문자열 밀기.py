def solution(A, B):
    count = 0
    if A == B:
        return count
    A = list(A)
    B = list(B)
    while True:
        A.insert(0, A[-1])
        A.pop()
        count += 1
        if count >= len(A):
            return -1
        if ''.join(A) == ''.join(B):
            return count