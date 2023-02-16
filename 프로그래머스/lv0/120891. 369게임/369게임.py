def solution(order):
    samyookgoo = [3,6,9]
    answer = 0
    for i in str(order):
        if int(i) in samyookgoo:
            answer += 1
    return answer