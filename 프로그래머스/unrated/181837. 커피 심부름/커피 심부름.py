def solution(order):
    answer = 0
    # americano = 4500, latte = 5000, anything = 4500
    for i in order:
        if 'americano' in i or 'anything' in i:
            answer += 4500
        elif 'latte' in i:
            answer += 5000
    return answer