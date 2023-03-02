def solution(d, budget):
    answer = 0
    while True:
        if d == []:
            break
        if budget < min(d):
            break
        price = min(d)
        d.remove(price)
        budget -= price
        answer += 1
    return answer