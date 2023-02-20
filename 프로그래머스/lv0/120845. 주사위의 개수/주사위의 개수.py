def solution(box, n):
    answer = 1
    for side in box:
        answer *= side // n
    return answer