def solution(sides):
    #가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
    side = 0
    answer = 0
    while side <= sum(sides):
        side += 1
        sides.append(side)
        if max(sides) < sum(sides) - max(sides):
            answer += 1
        sides.pop()
    return answer